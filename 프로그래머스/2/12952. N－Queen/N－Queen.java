class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));  // N = 4일 때 가능한 경우의 수 출력
    }

    private int answer = 0;
    private int[][] board;

    public int solution(int n) {
        board = new int[n][n];
        dfs(0, n);
        return answer;
    }

    private void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (canPutQueen(row, i, n)) {
                board[row][i] = 1;
                dfs(row + 1, n);
                board[row][i] = 0;
            }
        }
        
    }

    private boolean canPutQueen(int row, int col, int n) {
        for (int i = 1; i <= n; i++) {
            if (board[i - 1][col] == 1) return false;
            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] == 1) return false;
            if (row - i >= 0 && col + i < n && board[row - i][col + i] == 1) return false;
        }

        return true;
    }

}