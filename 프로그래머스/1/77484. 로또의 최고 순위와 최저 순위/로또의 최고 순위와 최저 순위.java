import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {44, 1, 0, 0, 31, 25};
        int[] b = {31, 10, 45, 1, 6, 19};
        sol.solution(a, b);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] correctNumber = new boolean[46];
        for (int num : win_nums) {
            correctNumber[num] = true;
        }

        int correct = 0;
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zeroCnt++;
            if (correctNumber[lotto]) correct++;
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);

        return new int[]{map.get(correct + zeroCnt), map.get(correct)};
    }

}
