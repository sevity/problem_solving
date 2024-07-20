package java;
//내가 오해했네, 토큰 버킷방식은 Node 같은 struct개념도 필요없고,
//자료구조도 필요없고,
//그냥 lastRefillTime, tokens 이 두개 변수만 가지고 컨트롤 하는거네 ㅎ 
//슬라이딩 윈도우대비해서 매번 timestamp를 저장하지도 않고 좋네..
import java.util.*;

class TokenBucketRateLimiter {
    private final int maxTokens; // 버킷의 최대 토큰 수
    private final long refillRateInMillis; // 토큰이 리필되는 시간 간격(밀리초 단위)
    private Map<String, Long> userTokens; // 각 사용자의 현재 토큰 수를 추적하는 맵
    private Map<String, Long> userLastRefillTimes; // 각 사용자의 마지막 토큰 리필 시간을 추적하는 맵

    public TokenBucketRateLimiter(int maxTokens, long refillRateInSeconds) {
        this.maxTokens = maxTokens;
        this.refillRateInMillis = refillRateInSeconds * 1000; // 초를 밀리초로 변환
        this.userTokens = new HashMap<>();
        this.userLastRefillTimes = new HashMap<>();
    }

    public synchronized boolean isAllowed(String userId) {
        long currentTime = System.currentTimeMillis(); // 현재 시간을 밀리초 단위로 가져옴
        long lastRefillTime = userLastRefillTimes.getOrDefault(userId, currentTime); // 사용자의 마지막 리필 시간 가져옴
        long tokens = userTokens.getOrDefault(userId, (long) maxTokens); // 사용자의 현재 토큰 수 가져옴

        // 토큰 리필 계산: (현재 시간 - 마지막 리필 시간) / 리필 간격으로 리필 토큰 수 계산
        // 여기가 핵심이네 뭉텅이로 추가되는게 아니라 하나씩 부드럽게 추가되네..
        long refillTokens = (currentTime - lastRefillTime) / refillRateInMillis;
        tokens = Math.min(tokens + refillTokens, maxTokens); // 최대 토큰 수를 초과하지 않게 리필
        userLastRefillTimes.put(userId, currentTime); // 마지막 리필 시간 업데이트

        // 요청 허용 여부 확인
        if (tokens > 0) {
            userTokens.put(userId, tokens - 1); // 토큰 사용
            return true; // 요청 허용
        }

        return false; // 요청 거부
    }


    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(3, 1); // 1초에 3개의 토큰 리필

        // 테스트 케이스 1: 사용자1에 대한 3개의 연속 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 2: 사용자1에 대한 추가 요청 (거부)
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: false

        // 테스트 케이스 3: 1초 대기 후 사용자1에 대한 추가 요청 (허용)
        Thread.sleep(1000);
        System.out.println(rateLimiter.isAllowed("user1")); // 출력: true

        // 테스트 케이스 4: 사용자2에 대한 첫 요청 (허용)
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: true

        // 테스트 케이스 5: 사용자2에 대한 3개의 추가 요청 (2개 허용, 1개 거부)
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: true
        System.out.println(rateLimiter.isAllowed("user2")); // 출력: false
    }
}
