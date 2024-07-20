import java.util.ArrayList;
import java.util.List;

public class ArrayLongestSubArray {
    public static int findLongestNonDescendingSubarray(List<Integer> arr) {
        int longest = 0;
        int cur_run = 1;
        int n = arr.size();
        for (int i = 1; i < n; i++) {
            if (arr.get(i) >= arr.get(i - 1)) cur_run++;
            else {
                longest = Math.max(longest, cur_run);
                cur_run = 1;
            }
        }
        longest = Math.max(longest, cur_run);
        return longest;
    }

    public static void main(String args[]) {
        // 테스트 케이스
        int[][] testCases = {
            {1, 2, 3, 2, 3, 4},
            {5, 5, 5, 5},
            {1, 2, 1, 2, 3},
            {3, 2, 1, 2, 3, 4, 5},
            {10, 9, 8, 7, 6}
        };

        for (int[] testCase : testCases) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < testCase.length; i++) arr.add(testCase[i]);
            int result = findLongestNonDescendingSubarray(arr);
            System.out.println("Longest non-descending subarray length for " + arr + " is " + result);
        }
    }
}
