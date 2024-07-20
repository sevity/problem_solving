import java.util.*;

public class BinarySearchLIS {
    static int lower_bound(List<Integer> arr, int find) {
        int left = 0, right = arr.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) == find) return mid;
            if (arr.get(mid) < find) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    static int findLISLength(int[] inputArr) {
        List<Integer> arr = new ArrayList<>();
        for (int i : inputArr) arr.add(i);
        List<Integer> tails = new ArrayList<>();
        tails.add(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            int lb = lower_bound(tails, arr.get(i));
            if (lb == tails.size()) tails.add(arr.get(i));
            else tails.set(lb, arr.get(i));
            int sfsd = 1;
        }
        return tails.size();
    }

    public static void main(String args[]) {
        int[] testCase1 = {1, 10, 2, 3, 4, 5};
        int[] testCase2 = {5, 4, 3, 2, 1};
        int[] testCase3 = {1, 2, 3, 4, 5};

        System.out.println(findLISLength(testCase1)); // 출력: 4
        System.out.println(findLISLength(testCase2)); // 출력: 1
        System.out.println(findLISLength(testCase3)); // 출력: 5
    }
}
