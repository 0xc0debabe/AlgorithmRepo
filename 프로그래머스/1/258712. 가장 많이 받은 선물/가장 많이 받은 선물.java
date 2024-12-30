

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] fri = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gif = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        System.out.println(solution.solution(fri, gif));
    }


    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> hashMap = new HashMap<>();

        int idx = 0;
        for (String friend : friends) {
            hashMap.put(friend, idx++);
        }
        int n = friends.length;

        int[][] giftGraph = new int[n][n];
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int from = hashMap.get(split[0]);
            int to = hashMap.get(split[1]);

            giftGraph[from][to]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            int giveGift = 0;
            int getGift = 0;

            for (int j = 0; j < n; j++) {
                getGift += giftGraph[j][i];
                giveGift += giftGraph[i][j];
            }

            giftIndex[i] = giveGift - getGift;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftGraph[i][j] > giftGraph[j][i]) {
                    answer[i]++;
                } else if (giftGraph[i][j] < giftGraph[j][i]) {
                    answer[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        answer[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        answer[j]++;
                    }
                }
            }
        }

        Arrays.sort(answer);
        return answer[answer.length - 1];
    }


}
