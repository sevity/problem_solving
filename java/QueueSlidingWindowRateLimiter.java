package java;
import java.util.*;

class QueueSlidingWindowRateLimiter {
    private final int maxRequests; // 허용된 시간 창 내에서 허용되는 최대 요청 수
    private final long timeWindowInMillis; // 허용된 요청 수를 계산하는 데 사용되는 시간 창(밀리초 단위)
    private Map<String, Queue<Long>> userRequests; // 각 사용자의 최근 요청 타임스탬프를 추적하는 맵

    public QueueSlidingWindowRateLimiter(int maxRequests, long timeWindowInSeconds) {
        this.maxRequests = maxRequests;
        this.timeWindowInMillis = timeWindowInSeconds * 1000;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis(); // 현재 시간을 밀리초 단위로 가져옴
        Queue<Long> requests = userRequests.getOrDefault(userId, new ArrayDeque<>());

        // 오래된 요청 제거(단순하게 queue.peek 해서 윈도우크기보다 오래됐으면 전부 제거)
        while (!requests.isEmpty() && currentTime - requests.peek() > timeWindowInMillis) {
            requests.poll();
        }

        // 현재 요청이 허용되는지 확인
        if (requests.size() < maxRequests) {
            requests.offer(currentTime);
            userRequests.put(userId, requests);
            return true; // 요청 허용
        }

        return false; // 요청 거부
    }
    public static void main(String[] args) throws InterruptedException {
        QueueSlidingWindowRateLimiter rateLimiter = new QueueSlidingWindowRateLimiter(3, 1); // 1초 동안 최대 3개의 요청 허용

        // 테스트 케이스 1: 사용자1에 대한 3개의 연속 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 2: 사용자1에 대한 추가 요청 (거부)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: false

        // 테스트 케이스 3: 500ms 대기 후 사용자1에 대한 추가 요청 (거부)
        Thread.sleep(500);
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: false

        // 테스트 케이스 4: 추가 600ms 대기 후 사용자1에 대한 추가 요청 (허용)
        Thread.sleep(600);
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 5: 사용자2에 대한 첫 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: true
    }
}
