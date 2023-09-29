import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class C_Rotate_Colored_Subsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        char[] S = scanner.next().toCharArray();
        int[] C = new int[N];

        for (int i = 0; i < N; i++) {
            C[i] = scanner.nextInt();
        }

        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        // 색상별 해시맵 생성
        for (int i = 0; i < N; i++) {
            String a = map.getOrDefault(C[i],"");
            List<Integer> b = map2.getOrDefault(C[i],new ArrayList<>());
            a+=S[i];map.put(C[i],a);
            b.add(i);map2.put(C[i],b);
        }
        for (int color = 1; color <= M; color++) {
            String a = map.get(color);
            List<Integer> b = map2.get(color);
            assert(a.length()==b.size());
            for(int i=0;i<b.size();i++){
                int shited_i = (i - 1 + b.size()) % b.size();
                S[b.get(i)] = a.charAt(shited_i);
            }
        }



/*
        // 각 색상별로 작업을 수행
        for (int color = 1; color <= M; color++) {
            int count = 0; // 현재 색상이 몇 번 나타나는지 카운트
            char[] temp = new char[N];

            // 현재 색상에 대한 문자들을 임시 배열에 저장
            for (int i = 0; i < N; i++) {
                if (C[i] == color) {
                    temp[count] = S[i];
                    count++;
                }
            }

            // 오른쪽 순환 시프트 수행
            for (int i = 0, j = 0; i < N; i++) {
                if (C[i] == color) {
                    S[i] = temp[(j - 1 + count) % count];
                    j++;
                }
            }
        }
*/
        System.out.println(new String(S));
        scanner.close();
    }
}
