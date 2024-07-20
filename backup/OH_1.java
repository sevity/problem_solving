import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OH_1 {
    public static boolean canArrangeCards(int[] cards, int slotSize) {
        if (cards.length % slotSize != 0) {
            return false;
        }

        Arrays.sort(cards);

        int count = 1;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i] == cards[i - 1] + 1) {
                count++;
            } else if (cards[i] == cards[i - 1]) {
                // 같은 숫자는 무시 (중복된 숫자 그룹 처리)
            } else {
                if (count != slotSize) {
                    return false; // 보관함이 가득 차지 않았다면 실패
                }
                count = 1; // 새로운 보관함 시작
            }

            if (count > slotSize) {
                return false;
            }

            if (count == slotSize) {
                count = 0;
            }
        }

        return count == 0;
    }
    

    public static void main(String[] args) {
        int[] cards = {1,2,3,2,3,4};
        int slotSize = 3;

        if (canArrangeCards(cards, slotSize)) {
            System.out.println("카드를 보관함에 정리할 수 있습니다.");
        } else {
            System.out.println("카드를 보관함에 정리할 수 없습니다.");
        }
    }
}