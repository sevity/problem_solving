package java;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stats {
    private List<Long> responseTimes;

    public Stats() {
        responseTimes = new ArrayList<>();
    }

    public void addResponseTime(long responseTime) {
        responseTimes.add(responseTime);
    }

    public double getMean() {
        long sum = 0;
        for (long time : responseTimes) {
            sum += time;
        }
        return (double) sum / responseTimes.size();
    }

    public double getTP95() {
        Collections.sort(responseTimes);
        int index = (int) (responseTimes.size() * 0.95);
        return responseTimes.get(index);
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        Stats stats1 = new Stats();
        stats1.addResponseTime(100);
        stats1.addResponseTime(200);
        stats1.addResponseTime(300);
        System.out.println("Mean: " + stats1.getMean()); // 출력: Mean: 200.0
        System.out.println("TP95: " + stats1.getTP95()); // 출력: TP95: 300

        // 테스트 케이스 2
        Stats stats2 = new Stats();
        stats2.addResponseTime(50);
        stats2.addResponseTime(50);
        stats2.addResponseTime(50);
        System.out.println("Mean: " + stats2.getMean()); // 출력: Mean: 50.0
        System.out.println("TP95: " + stats2.getTP95()); // 출력: TP95: 50

        // 추가 테스트 케이스 3, 4, 5는 비슷한 방식으로 구성할 수 있습니다.
    }
}
