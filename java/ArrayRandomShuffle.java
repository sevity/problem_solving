import java.util.Random;

public class ArrayRandomShuffle {
    // 1부터 n까지의 무작위 정수를 반환하는 메소드
    public static int random(int n) {
        Random rand = new Random();
        return rand.nextInt(n) + 1;
    }

    // 1부터 arrLength까지의 숫자를 무작위로 배열에 배치하는 메소드
    public static int[] randomArray(int arrLength) {
        int[] result = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            result[i] = i + 1;
        }

        // Fisher-Yates 셔플 알고리즘을 사용하여 배열을 랜덤하게 섞음
        for (int i = arrLength - 1; i > 0; i--) {
            int randomIndex = random(i + 1) - 1;
            int temp = result[i];
            result[i] = result[randomIndex];
            result[randomIndex] = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] testCases = {3, 4, 5, 6, 7};

        for (int testCase : testCases) {
            int[] result = randomArray(testCase);
            System.out.print("Input: " + testCase + " > Output: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
