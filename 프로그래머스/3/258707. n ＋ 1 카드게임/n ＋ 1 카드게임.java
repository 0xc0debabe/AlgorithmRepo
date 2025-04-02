import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4};
        solution.solution(4, arr);

    }

    public int solution(int coin, int[] cards) {
        Set<Integer> myCard = new HashSet<>();
        Set<Integer> newCard = new HashSet<>();

        int len = cards.length;
        int target = len + 1;
        for (int i = 0; i < len / 3; i++) {
            int card = cards[i];
            myCard.add(card);
        }

        int round = 0;
        for (int i = len / 3; i <= len; i += 2) {
            round++;
            if (i >= len) break;
            int card1 = cards[i];
            int card2 = cards[i + 1];

            newCard.add(card1);
            newCard.add(card2);
            boolean flag = false;

            for (int card : myCard) {
                if (myCard.contains(target - card)) {
                    myCard.remove(card);
                    myCard.remove(target - card);
                    flag = true;
                    break;
                }
            }

            if (!flag && coin >= 1) {
                for (int card : myCard) {
                    if (newCard.contains(target - card)) {
                        myCard.remove(card);
                        newCard.remove(target - card);
                        flag = true;
                        coin--;
                        break;
                    }
                }
            }

            if (!flag && coin >= 2) {
                for (int card : newCard) {
                    if (newCard.contains(target - card)) {
                        newCard.remove(card);
                        newCard.remove(target - card);
                        flag = true;
                        coin -= 2;
                        break;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        return round;
    }

}