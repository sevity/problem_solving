import java.util.*;
public class DP_LIS {

    public static void main(String args[]){
        Integer[] numbers = {5, 2, 8, 1, 3, 7};
        List<Integer> number_list = Arrays.asList(numbers);
        Collections.sort(number_list, Collections.reverseOrder());  // 이경우는 Collections.sort()는 못쓴다.
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        //Integer[] dp2 = new Integer[100];
        //Arrays.sort(dp2, Collections.reverseOrder());

        // LIS는 아마도 DP에서 가장 기본적인걸꺼야.
        // 브루트포스에서 시간복잡도는 얼마일까 모든 조합 O(2^n)에 체크하는데 n씩이니까 결국 O(2^n)이네 ㅎ
        // 리컬시브로 하면 왠지 편할거 같다. 한번 해보자.
        // 음 막상해보니 iterative가 더 편하게 느껴진다 ㅠ.ㅠ 이점은 나중에 복기해보자.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++) arr.add(sc.nextInt());
        int[] dp = new int[100];Arrays.fill(dp, 1);// 한개로는 항상 성립(***)
        // dp[3] = 4면은 3까지의 LIS는 4다.
        for(int i=1;i<arr.size();i++){
            for(int j=0;j<i;j++) if(arr.get(i)>=arr.get(j)) dp[i]=Math.max(dp[i], dp[j]+1);
        }
        Arrays.sort(dp); // dp중간것이 답일수있다 (***)
        System.out.println(dp[dp.length-1]);

        sc.close();
    }
}
