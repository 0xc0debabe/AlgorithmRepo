import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 3, 2};
        String[] as = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        sol.solution(arr, as);
    }

    public int solution(int[] picks, String[] minerals) {
        int[][] pirodo = {
                {1, 1, 1},
                {5, 1, 1},
                {25, 5, 1}
        };

        picks = Arrays.stream(picks).map(i -> i * 5).toArray();
        int idx = 0;
        int answer = 0;
        for (int i = 0; i < picks.length; i++) {
            while (idx < minerals.length && picks[i] > 0) {
                picks[i]--;
                if (minerals[idx].equals("diamond")) {
                    answer += pirodo[i][0];
                } else if (minerals[idx].equals("iron")) {
                    answer += pirodo[i][1];
                } else {
                    answer += pirodo[i][2];
                }
                idx++;
            }
        }

        return answer;
    }

}