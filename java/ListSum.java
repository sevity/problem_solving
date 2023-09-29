package java;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSum {
    public static List<Integer> sumTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> ret = new ArrayList<>();

        if (list1.size() != list2.size()){
            throw new IllegalArgumentException("arg size should be the same!");
        }
        for(int i=0;i<list1.size();i++)
            ret.add(list1.get(i)+list2.get(i));
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(5, 6, 7, 8);

        List<Integer> result = sumTwoLists(list1, list2);
        System.out.println(result); // 출력: [6, 8, 10, 12]
    }
}
