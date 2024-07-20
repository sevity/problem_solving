package java;
import java.util.*;
public class KnapsackCoin {
    static final int max_int = 999999;
    static final int[][] memo = new int[10][max_int];

    static int sub(List<Integer> coins, int amount, int coin_ix, int current_ammount){
        if(coin_ix>=coins.size()) return max_int;
        if(current_ammount==amount) return 0;
        if(current_ammount>amount) return max_int;
        if(memo[coin_ix][current_ammount]!=-1) return memo[coin_ix][current_ammount];
        
        int r1 = 1 + sub(coins, amount, coin_ix  , current_ammount+coins.get(coin_ix)); // 포함
        int r2 = sub(coins, amount, coin_ix+1, current_ammount);  // 불포함
        int r3 = Math.min(r1, r2);
        memo[coin_ix][current_ammount] = r3;
        return memo[coin_ix][current_ammount];
    }

    static int func(List<Integer> coins, int amount){
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < max_int; j++) memo[i][j] = -1;
        int r = sub(coins, amount, 0, 0);
        if(r>=max_int) r=-1;
        return r;
    }

/*
    public static void main(String args[]){
        for(int i=0;i<10;i++)for(int j=0;j<max_int;j++) memo[i][j]=-1;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0;i<n;i++) coins.add(sc.nextInt());
        int amount = sc.nextInt();
        System.out.println(func(coins, amount));
        sc.close();
    }
*/
    public static void main(String args[]) {

        List<List<Integer>> testCoins = new ArrayList<>();
        List<Integer> testAmounts = new ArrayList<>();
        List<Integer> expectedResults = new ArrayList<>();

        // 문제에서 제시된 테스트 케이스
        testCoins.add(Arrays.asList(1, 2, 5));
        testAmounts.add(11);
        expectedResults.add(3);

        testCoins.add(Arrays.asList(8, 5, 3, 2));
        testAmounts.add(12);
        expectedResults.add(3);

        testCoins.add(Arrays.asList(2));
        testAmounts.add(3);
        expectedResults.add(-1);

        // 추가 테스트 케이스
        testCoins.add(Arrays.asList(2, 4));
        testAmounts.add(7);
        expectedResults.add(-1); // 불가능한 경우

        testCoins.add(Arrays.asList(1, 2, 3));
        testAmounts.add(0);
        expectedResults.add(0); // 금액이 0인 경우

        testCoins.add(Arrays.asList(1, 2, 3));
        testAmounts.add(13);
        expectedResults.add(5); // 금액이 0인 경우

        // 하나의 코인이 여러 번 사용되는 복잡한 케이스
        testCoins.add(Arrays.asList(3, 4, 5));
        testAmounts.add(9);
        expectedResults.add(2); // 4 + 5

        testCoins.add(Arrays.asList(7, 2, 3));
        testAmounts.add(14);
        expectedResults.add(2); // 7 + 7

        testCoins.add(Arrays.asList(6, 4, 2));
        testAmounts.add(24);
        expectedResults.add(4); // 6 + 6 + 6 + 6        

        for (int i = 0; i < testCoins.size(); i++) {
            List<Integer> coins = testCoins.get(i);
            int amount = testAmounts.get(i);
            int expectedResult = expectedResults.get(i);
            System.out.println("Coins: " + coins + ", Amount: " + amount);
            System.out.println("Expected Result: " + expectedResult);
            System.out.println("Actual Result: " + func(coins, amount));
            System.out.println();
        }
    }
}
/*
iterative solution
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
            if (dp[i - coin] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }

    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
}
 */

