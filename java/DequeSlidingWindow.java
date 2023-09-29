import java.util.*;

/* 맨오른쪽 상황이 dequeue안쪽이다. 항상 윈도우내 가장 큰 값을 저장(실제로는 값이 아닌 인덱스를 저장)
[1 3 -1]-3 5 3 6 7 [3 -1]
1[3 -1 -3] 5 3 6 7 [3 -1 -3]
1 3[-1 -3 5] 3 6 7 [5]
13 -1 [-3 5 3] 6 7 [5 3]
13 -1 -3[5 3 6]  7 [6]
13 -1 -3 5 [3 6 7] [7]

우선순위큐를 쓸경우 윈도우 지나간것을 효율적으로 제거하기 힘듬
 */


public class DequeSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 입력값의 유효성 검사
        if (nums == null || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // 결과를 저장할 배열
        Deque<Integer> deque = new LinkedList<>(); // 현재 슬라이딩 윈도우 내의 요소를 저장할 덱

        for (int i = 0; i < n; i++) {
            // 덱의 첫 번째 요소가 슬라이딩 윈도우 범위를 벗어나면 제거
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // 덱의 마지막 요소가 현재 요소보다 작으면 제거 (현재 요소가 덱에 있는 요소보다 크므로)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 현재 인덱스를 덱에 추가
            deque.offer(i);

            // 슬라이딩 윈도우의 첫 번째 요소를 결과 배열에 추가
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result)); // 출력: [3, 3, 5, 5, 6, 7]
    }
}
