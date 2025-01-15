import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}};
        solution.solution(arr);
    }

    public int[] solution(int[][] edges) {
        Map<Integer, Integer> inMap = new HashMap<>();
        Map<Integer, Integer> outMap = new HashMap<>();

        int[] answer = new int[4];
        int max = 0;
        for (int[] edge : edges) {
            int out = edge[0];
            int in = edge[1];
            max = Math.max(max, Math.max(out, in));

            outMap.put(out, outMap.getOrDefault(out, 0) + 1);
            inMap.put(in, inMap.getOrDefault(in, 0) + 1);
        }

        for (int i = 1; i <= max; i++) {
            if (inMap.containsKey(i) && outMap.containsKey(i)) {
                if (outMap.get(i) >= 2 && inMap.get(i) >= 2) {
                    answer[3] += 1;
                }
            } else if (!outMap.containsKey(i) && inMap.containsKey(i)) {
                answer[2] += 1;
            } else if (!inMap.containsKey(i) && outMap.containsKey(i)) {
                if (outMap.get(i) >= 2) {
                    answer[0] = i;
                }
            }
        }

        answer[1] = outMap.get(answer[0]) - (answer[2] + answer[3]);

        return answer;
    }


}