
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
        System.out.println(solution.solution(3, 6, arr));
    }

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[2][m + 1][n + 1];

        dp[0][0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 0) {
                    dp[0][i + 1][j] += (dp[0][i][j] + dp[1][i][j]) % MOD;
                    dp[1][i][j + 1] += (dp[0][i][j] + dp[1][i][j]) % MOD;
                } else if (cityMap[i][j] == 2) {
                    dp[0][i + 1][j] = (dp[0][i + 1][j] + dp[0][i][j]) % MOD;
                    dp[1][i][j + 1] = (dp[1][i][j + 1] + dp[1][i][j]) % MOD;
                }
            }
        }

        return (dp[0][m - 1][n - 1] + dp[1][m - 1][n - 1]) % MOD;
    }

}
