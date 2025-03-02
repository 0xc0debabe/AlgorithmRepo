
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution.solution(land));
    }

    int solution(int[][] land) {
        int[][] dp = new int[land.length + 1][land[0].length];

        for (int i = 1; i <= land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {

                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;

                    if (max < land[i - 1][k] + dp[i - 1][k]) {
                        dp[i][j] = land[i - 1][k] + dp[i - 1][k];
                        max = land[i - 1][k] + dp[i - 1][k];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < dp[0].length; i++) {
            answer = Math.max(answer, dp[land.length][i]);
        }

        return answer;
    }

}