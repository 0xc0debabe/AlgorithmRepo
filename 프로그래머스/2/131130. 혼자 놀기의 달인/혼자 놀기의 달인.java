import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 9, 10 , 1};
        System.out.println(solution.solution(arr));
    }

    public int solution(int[] cards) {
        boolean[] isVisited = new boolean[cards.length + 1];

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= cards.length; i++) {
            if (isVisited[i]) continue;

            int nowCard = cards[i - 1];
            int cnt = 0;
            while (!isVisited[nowCard]) {
                isVisited[nowCard] = true;
                nowCard = cards[nowCard - 1];
                cnt++;
            }

            list.add(cnt);
        }

        Collections.sort(list);
        if (list.size() == 1) return 0;
        return list.get(list.size() - 1) * list.get(list.size() - 2);
    }

}