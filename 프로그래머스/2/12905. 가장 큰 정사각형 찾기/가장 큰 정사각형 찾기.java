class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        System.out.println(solution.solution(arr));
    }

    public int solution(int[][] board) {

        int n = board.length;
        int m = board[0].length;

        int[][] dp = new int[n + 1][m + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer * answer;
    }


}