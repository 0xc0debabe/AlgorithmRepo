class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        solution.solution(arr);
    }

    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length + 1][triangle[triangle.length - 1].length];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][Math.max(0, j - 1)], dp[i - 1][j]) + triangle[i - 1][j];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}