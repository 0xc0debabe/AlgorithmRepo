class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {2, 2}
        };

        solution.solution(4, 3, arr);
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        int MOD = 1_000_000_007;

        dp[1][1] = 1;

        boolean[][] water = new boolean[n + 1][m + 1];
        for (int i = 0; i < puddles.length; i++) {
            int[] puddle = puddles[i];
            int pc = puddle[0];
            int pr = puddle[1];

            water[pr][pc] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (water[i][j] || (i == 1 && j == 1)) continue;

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        return dp[n][m];
    }

}