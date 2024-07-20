package java;
import java.util.Queue;
import java.util.ArrayDeque;

public class QueueWindowCircuitBreaker {
    private final double FAILURE_THRESHOLD = 0.5; // 실패율 임계값, 예: 50%
    private static final long SLIDING_WINDOW_TIME = 10000; // 예: 10초

    private Queue<Long> failureTimestamps = new ArrayDeque<>();  // 실패한 경우에만 기록
    private Queue<Long> totalRequestsTimestamps = new ArrayDeque<>();  // 성공해도 실패해도 기록

    public static class Response {
        @Override
        public String toString() {
            return "Response 객체반환 성공";
        }
    }

    public static class APIException extends Exception {
        public APIException(String message) {
            super(message);
        }
    }

    public Response rpcProxy(int param1, String param2) throws APIException {
        long currentTime = System.currentTimeMillis();
        // 오래된 실패 이벤트 제거
        while (!failureTimestamps.isEmpty() && (currentTime - failureTimestamps.peek() > SLIDING_WINDOW_TIME)) {
            failureTimestamps.poll();
        }
        // 오래된 전체 요청 이벤트 제거(성공/실패 모두 포함)
        while (!totalRequestsTimestamps.isEmpty() && (currentTime - totalRequestsTimestamps.peek() > SLIDING_WINDOW_TIME)) {
            totalRequestsTimestamps.poll();
        }

        // 실패율 계산
        double failureRate = totalRequestsTimestamps.size() == 0 
            ? 0 
            : (double) failureTimestamps.size() / totalRequestsTimestamps.size();

        // 서킷 브레이커 상태 결정
        // HALF-OPEN상태는 없지만 실패율이 높으면 OPEN된 이후 시간이 지나면서 실패율이 낮아지면서 다시 CLOSE되는 구조
        if (failureRate > FAILURE_THRESHOLD) {
            throw new APIException("Circuit Breaker is OPEN due to high failure rate");
        }

        // 여기까지 오면 CLOSE상태.

        try {
            Response response = rpc(param1, param2);
            totalRequestsTimestamps.add(currentTime); // 전체 요청 타임스탬프 추가
            return response;
        } catch (APIException e) {
            failureTimestamps.add(currentTime); // 실패 이벤트 타임스탬프 추가
            totalRequestsTimestamps.add(currentTime); // 전체 요청 타임스탬프 추가
            throw e;
        }
    }

    public Response rpc(int param1, String param2) throws APIException {
        // 여기에 실제 RPC 로직 구현
        if (param2.equals("fail")) {
            throw new APIException("RPC 실패");
        }
        return new Response();
    }

    public static void main(String[] args) {
        QueueWindowCircuitBreaker circuitBreaker = new QueueWindowCircuitBreaker();
    
        // 테스트 케이스 1: 정상적인 호출
        try {
            Response response = circuitBreaker.rpcProxy(1, "param1");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 1 성공");
        } catch (Exception e) {
            System.out.println("테스트 케이스 1 실패: " + e.getMessage());
        }
    
        // 테스트 케이스 2: 연속된 실패 호출
        for (int i = 0; i < 3; i++) {
            try {
                circuitBreaker.rpcProxy(2, "fail");
                assert false : "예외가 발생해야 함";
            } catch (APIException e) {
                assert e.getMessage().equals("RPC 실패") || e.getMessage().equals("Circuit Breaker is OPEN due to high failure rate");
                System.out.println("테스트 케이스 2 실패 " + (i + 1) + ": " + e.getMessage());
            }
        }
    
        // 테스트 케이스 3: OPEN 상태에서의 호출
        try {
            circuitBreaker.rpcProxy(3, "param3");
            assert false : "예외가 발생해야 함";
        } catch (APIException e) {
            assert e.getMessage().equals("Circuit Breaker is OPEN due to high failure rate");
            System.out.println("테스트 케이스 3 성공");
        }
    
        // 테스트 케이스 4: 정상 호출 후 CLOSED 상태로 복귀
        try {
            Thread.sleep(SLIDING_WINDOW_TIME + 1000); // 슬라이딩 윈도우 시간 초과 대기
            Response response = circuitBreaker.rpcProxy(4, "param4");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 4 성공");
        } catch (Exception e) {
            System.out.println("테스트 케이스 4 실패: " + e.getMessage());
        }
    
        // 테스트 케이스 5: CLOSED 상태에서의 정상 호출
        try {
            Response response = circuitBreaker.rpcProxy(5, "param5");
            assert response.toString().equals("Response 객체반환 성공");
            System.out.println("테스트 케이스 5 성공");
        } catch (APIException e) {
            System.out.println("테스트 케이스 5 실패: " + e.getMessage());
        }
    }
    
}

