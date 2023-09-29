package java;
import java.util.*;

public class ListMedian {
    public static double findMedian(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        int n1 = list1.size();
        int n2 = list2.size();
        int N = n1 + n2;
        //합친 리스트의 개수가 홀수개이면 n/2 번째인덱스
        //짝수개이면 n/2-1, n/2번째 인덱스의 평균이 답

        int mid_six = N % 2 == 1 ? N / 2 : N / 2 - 1;
        int mid_eix = N % 2 == 1 ? N / 2 : N / 2;

        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator();
        int median1 = 0, median2 = 0;
        for (int i = 0; i <= mid_eix; i++) {
            int v1 = it1.hasNext() ? it1.next() : Integer.MAX_VALUE;
            int v2 = it2.hasNext() ? it2.next() : Integer.MAX_VALUE;

            int value;
            if (v1 < v2) {
                value = v1;
                if (v2 < Integer.MAX_VALUE) it2.previous();
            } else {
                value = v2;
                if (v1 < Integer.MAX_VALUE) it1.previous();
            }

            if (i == mid_six) median1 = value;
            if (i == mid_eix) median2 = value;
        }
        return (double) (median1 + median2) / 2.0;
    }

    public static void main(String args[]) {
        int[][] testCases1 = {
            {1, 3},
            {1, 2},
            {5, 7, 9},
            {2, 4, 6},
            {10}
        };

        int[][] testCases2 = {
            {2},
            {3, 4},
            {6, 8},
            {1, 3, 5},
            {11, 12, 13}
        };

        for (int i = 0; i < testCases1.length; i++) {
            LinkedList<Integer> list1 = new LinkedList<>();
            LinkedList<Integer> list2 = new LinkedList<>();
            for (int num : testCases1[i]) list1.add(num);
            for (int num : testCases2[i]) list2.add(num);

            double median = findMedian(list1, list2);
            System.out.println("Median of " + list1 + " and " + list2 + " is " + median);
        }
    }
}
