public class CircuitBreaker {
    private final int FAILURE_THRESHOLD = 5; // 실패 허용 횟수
    private final long OPEN_TO_HALF_OPEN_TIME = 10000; // OPEN에서 HALF-OPEN으로 전환되기까지의 시간 (10초)

    private int failureCount = 0;
    private long lastFailedTime = 0;
    private State state = State.CLOSED;

    public static class Response {
        @Override
        public String toString() {
            return "Response 객체반환 성공";
        }
    } 
    
    // 더미 ApiException 클래스
    public static class ApiException extends Exception {
        public ApiException(String message) {
            super(message);
        }
    }


    private enum State {
        CLOSED, OPEN, HALF_OPEN
    }

    public Response callRpc(int param1, String param2) throws ApiException {
        System.out.println("callRpc current state:" + state);
        switch (state) {
            case CLOSED:
                try {
                    if(param2 == "fail") throw new ApiException("test");
                    Response response = rpc(param1, param2);
                    resetFailureCount();
                    return response;
                } catch (ApiException e) {
                    increaseFailureCount();
                    if (failureCount > FAILURE_THRESHOLD) {
                        openCircuit();
                    }
                    throw e;
                }
            case OPEN:
                if (System.currentTimeMillis() - lastFailedTime > OPEN_TO_HALF_OPEN_TIME) {
                    state = State.HALF_OPEN;
                    return callRpc(param1, param2);
                } else {
                    throw new ApiException("Circuit Breaker is OPEN");
                }
            case HALF_OPEN:
                try {
                    Response response = rpc(param1, param2);
                    resetFailureCount();
                    state = State.CLOSED;
                    return response;
                } catch (ApiException e) {
                    openCircuit();
                    throw e;
                }
        }
        throw new ApiException("Unknown Circuit Breaker state");
    }

    private void resetFailureCount() {
        failureCount = 0;
    }

    private void increaseFailureCount() {
        failureCount++;
    }

    private void openCircuit() {
        state = State.OPEN;
        lastFailedTime = System.currentTimeMillis();
    }

    // 기존 RPC 메서드
    public Response rpc(int param1, String param2) throws ApiException {
        // 여기에 실제 RPC 로직 구현
        return new Response();
    }

    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker();
        
        // 테스트 케이스 1: 정상적인 호출
        try {
            Response response = circuitBreaker.callRpc(1, "param1");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 1 성공");
        } catch (Exception e) {
            System.out.println("테스트 케이스 1 실패: " + e.getMessage());
        }

        // 테스트 케이스 2: 연속된 실패 호출
        for (int i = 0; i < 7; i++) {
            try {
                circuitBreaker.callRpc(2, "fail");
                assert false : "예외가 발생해야 함";
            } catch (ApiException e) {
                assert e.getMessage().equals("test") || e.getMessage().equals("Circuit Breaker is OPEN");
                System.out.println("테스트 케이스 2 실패 " + (i + 1) + ": " + e.getMessage());
            }
        }

        // 테스트 케이스 3: OPEN 상태에서의 호출
        try {
            Thread.sleep(5000);
            circuitBreaker.callRpc(3, "param3");
            assert false : "예외가 발생해야 함";
        } catch (ApiException e) {
            assert e.getMessage().equals("Circuit Breaker is OPEN");
            System.out.println("테스트 케이스 3 성공");
        } catch (InterruptedException e) {
            System.out.println("테스트 케이스 3 실패: 스레드가 중단되었습니다.");
        }

        // 테스트 케이스 4: HALF-OPEN 상태에서의 호출
        try {
            Thread.sleep(6000);
            Response response = circuitBreaker.callRpc(4, "param4");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 4 성공");
        } catch (ApiException e) {
            System.out.println("테스트 케이스 4 실패: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("테스트 케이스 4 실패: 스레드가 중단되었습니다.");
        }

        // 테스트 케이스 5: CLOSED 상태로 복귀
        try {
            Response response = circuitBreaker.callRpc(5, "param5");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 5 성공");
        } catch (ApiException e) {
            System.out.println("테스트 케이스 5 실패: " + e.getMessage());
        }
    }


}
