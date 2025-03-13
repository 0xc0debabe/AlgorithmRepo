import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 5};
        solution.solution(5, arr);
    }

    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[][] dp = new int[money.length + 1][n + 1];

        for (int i = 1; i <= money.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= money.length; i++) {
            int m = money[i - 1];
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];

                if (m <= j) {
                    dp[i][j] += dp[i][j - m];
                }
            }
        }

        return dp[money.length][n];
    }

}