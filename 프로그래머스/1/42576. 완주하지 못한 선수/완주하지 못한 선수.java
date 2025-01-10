import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] ar = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for (String c : completion) map.put(c, map.get(c) - 1);
        String answer = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

}
