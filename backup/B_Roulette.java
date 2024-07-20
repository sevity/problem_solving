import java.util.ArrayList;
import java.util.Scanner;

public class B_Roulette {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] bets = new int[N][];
        int minBets = Integer.MAX_VALUE;
        ArrayList<Integer> winners = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int Ci = scanner.nextInt();
            bets[i] = new int[Ci];
            for (int j = 0; j < Ci; j++) {
                bets[i][j] = scanner.nextInt();
            }
        }

        int X = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int bet : bets[i]) {
                if (bet == X) {
                    if (bets[i].length < minBets) {
                        winners.clear();
                        minBets = bets[i].length;
                        winners.add(i + 1);
                    } else if (bets[i].length == minBets) {
                        winners.add(i + 1);
                    }
                    break;
                }
            }
        }

        System.out.println(winners.size());
        if (winners.size() > 0) {
            for (int i : winners) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}
