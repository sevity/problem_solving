//고정 윈도우 방식.
//1초에 최대 3개 허용 (물론 고정 윈도우방식의 단점으로 인해 피크때는 더 허용될 수 있음.)
//고정윈도우라도 해도 개수에만 의존하는게 아니라 시간 프레임이 있다는점 유의.
//사용자마다 별도라는 점을 제외하면 변수2개로 단순카운팅 하는 것에 가깝다.
import java.util.*;

class FixedWindowRateLimiter {
    private final int maxRequests; // 허용된 시간 창 내에서 허용되는 최대 요청 수
    private final long timeWindowInSeconds; // 허용된 요청 수를 계산하는 데 사용되는 시간 창(초 단위)
    //요건 고정 윈도우 내의 개수를 카운팅. 유저별로 다르게 하기위해 map도입
    private Map<String, Integer> userRequestCounts; // 각 사용자의 현재 시간 창 내 요청 수를 추적하는 맵
    //요건 요청마다 갱신되진 않네.. 따라서 마지막(최근)이라고 보기 어려울수도? 유저별로 다르게 하기위해 map도입
    private Map<String, Long> userLastRequestTimes; // 각 사용자의 마지막 요청 시간을 추적하는 맵


    public FixedWindowRateLimiter(int maxRequests, long timeWindowInSeconds) {
        this.maxRequests = maxRequests;
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.userRequestCounts = new HashMap<>();
        this.userLastRequestTimes = new HashMap<>();
    }

    public synchronized boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis(); // 현재 시간을 밀리초 단위로 가져옴
        // 현재 시간 창의 시작 시간 계산
        // 같은 정수로 나누고 곱해서 현재 윈도우 시작 시간을 구한다.
        // 예를 들어 윈도우가 10초단위이고 현재초가 73초이면 70초가 나온다.
        long currentWindowStart = currentTime / (timeWindowInSeconds * 1000) * (timeWindowInSeconds * 1000); 

        // 사용자의 마지막(최신) 요청 시간을 확인하고, 현재 윈도우와 다르면 카운터를 초기화
        if (userLastRequestTimes.getOrDefault(userId, 0L) < currentWindowStart) {
            //최근 요청이 윈도우크기보다 옛날이면 고정윈도우 전체를 초기화 한다고 보면 된다.
            userRequestCounts.put(userId, 0);
            userLastRequestTimes.put(userId, currentWindowStart);
        }

        int requestCount = userRequestCounts.getOrDefault(userId, 0);
        if (requestCount < maxRequests) {
            userRequestCounts.put(userId, requestCount + 1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter(3, 1); // 1초 동안 최대 3개의 요청 허용

        // 테스트 케이스 1: 사용자1에 대한 3개의 연속 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 2: 사용자1에 대한 추가 요청 (거부)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: false

        // 테스트 케이스 3: 사용자2에 대한 첫 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: true

        // 테스트 케이스 4: 1초 대기 후 사용자1에 대한 추가 요청 (허용)
        Thread.sleep(1000);
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 5: 사용자1에 대한 3개의 추가 요청 (거부)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: false
    }
}
