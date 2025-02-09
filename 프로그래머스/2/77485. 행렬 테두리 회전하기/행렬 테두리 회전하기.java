class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        sol.solution(4, 4, a);

    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = i * columns + j + 1;
            }
        }

        int[] answer = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int[] query = queries[j];
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int temp = board[x1][y1];
            int min = temp;

            for (int i = x1; i < x2; i++) {
                board[i][y1] = board[i + 1][y1];
                min = Math.min(min, board[i][y1]);
            }

            for (int i = y1; i < y2; i++) {
                board[x2][i] = board[x2][i + 1];
                min = Math.min(min, board[x2][i]);
            }

            for (int i = x2; i > x1; i--) {
                board[i][y2] = board[i - 1][y2];
                min = Math.min(min, board[i][y2]);
            }

            for (int i = y2; i > y1 + 1; i--) {
                board[x1][i] = board[x1][i - 1];
                min = Math.min(min, board[x1][i]);
            }

            board[x1][y1 + 1] = temp;
            answer[j] = min;
        }

        return answer;
    }


}