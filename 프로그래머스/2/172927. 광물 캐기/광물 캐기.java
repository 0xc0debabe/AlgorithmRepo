class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 3, 2};
//        String[] as = {"stone", "stone", "stone", "stone", "stone", "diamond", "diamond", "diamond", "diamond", "diamond"};
        String[] as = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(sol.solution(arr, as));
    }

    private int answer = Integer.MAX_VALUE;
    private final int[][] fatigue = {
            {1, 1, 1}, // Diamond pickaxe
            {5, 1, 1}, // Iron pickaxe
            {25, 5, 1} // Stone pickaxe
    };

    public int solution(int[] picks, String[] minerals) {
        backtracking(picks, minerals, 0, 0);
        return answer;
    }

    private void backtracking(int[] picks, String[] minerals, int idx, int sum) {
        if (haveTool(picks) || idx > minerals.length) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                sum += cal(minerals, i, idx);
                backtracking(picks, minerals, idx + 5, sum);
                sum -= cal(minerals, i, idx);
                picks[i]++;
            }
        }
    }

    private int cal(String[] minerals, int weapon, int idx) {
        int sum = 0;
        for (int i = idx; i < Math.min(idx + 5, minerals.length); i++) {
            if (minerals[i].equals("diamond")) {
                sum += fatigue[weapon][0];
            } else if (minerals[i].equals("iron")) {
                sum += fatigue[weapon][1];
            } else {
                sum += fatigue[weapon][2];
            }
        }

        return sum;
    }

    private boolean haveTool(int[] picks) {
        for (int pick : picks) {
            if (pick > 0) return false;
        }

        return true;
    }


}