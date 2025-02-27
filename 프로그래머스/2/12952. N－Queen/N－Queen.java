class Solution {
    private int answer = 0;
    private int[][] board; // 체스판

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));  // N = 4일 때 가능한 경우의 수 출력
    }

    public int solution(int n) {
        board = new int[n][n];  // 체스판 초기화
        dfs(0, n);  // 첫 번째 행부터 시작
        return answer;
    }

    private void dfs(int row, int n) {
        if (row == n) { // 모든 행에 퀸을 배치 완료
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canPutQueen(row, col, n)) {
                board[row][col] = 1; // 퀸 배치
                dfs(row + 1, n); // 다음 행으로 이동
                board[row][col] = 0; // 백트래킹 (되돌리기)
            }
        }
    }

    private boolean canPutQueen(int row, int col, int n) {
        // 세로(열) 검사
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // 왼쪽 위 대각선 검사
        for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
            if (board[row - i][col - i] == 1) return false;
        }

        // 오른쪽 위 대각선 검사
        for (int i = 1; row - i >= 0 && col + i < n; i++) {
            if (board[row - i][col + i] == 1) return false;
        }

        return true; // 퀸을 놓을 수 있음
    }
}