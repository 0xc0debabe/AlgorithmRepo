class Solution {
    public static void main(String[] args) {
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        Solution solution = new Solution();
        solution.solution(board, skill);
    }

    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];

        for (int[] sk : skill) {
            int type = sk[0];
            int sr = sk[1];
            int sc = sk[2];
            int er = sk[3];
            int ec = sk[4];
            int degree = type == 1 ? -sk[5] : sk[5];

            sum[sr][sc] += degree;
            sum[er + 1][ec + 1] += degree;
            sum[sr][ec + 1] += degree * -1;
            sum[er + 1][sc] += degree * -1;
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] > 0) answer++;
            }
        }

        return answer;
    }



}