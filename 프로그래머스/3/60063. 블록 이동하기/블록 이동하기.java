import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[2][n][n]; // [dir][row][col]
        Queue<Robot> q = new LinkedList<>();

        // 초기 상태: (0,0)-(0,1), dir=1(가로)
        q.add(new Robot(0, 0, 0, 1, 1, 0));
        visited[1][0][0] = true;
        visited[1][0][1] = true;

        while (!q.isEmpty()) {
            Robot now = q.poll();

            int row1 = now.row1, col1 = now.col1;
            int row2 = now.row2, col2 = now.col2;
            int dir = now.dir;

            if ((row1 == n - 1 && col1 == n - 1) || (row2 == n - 1 && col2 == n - 1)) {
                return now.cnt;
            }

            // 이동
            for (int d = 0; d < 4; d++) {
                int nr1 = row1 + dr[d];
                int nc1 = col1 + dc[d];
                int nr2 = row2 + dr[d];
                int nc2 = col2 + dc[d];

                if (isValid(nr1, nc1, n, board) && isValid(nr2, nc2, n, board)) {
                    if (!visited[dir][nr1][nc1] || !visited[dir][nr2][nc2]) {
                        visited[dir][nr1][nc1] = true;
                        visited[dir][nr2][nc2] = true;
                        q.add(new Robot(nr1, nc1, nr2, nc2, dir, now.cnt + 1));
                    }
                }
            }

            // 회전
            if (dir == 1) { // 가로 → 세로 회전
                for (int d = -1; d <= 1; d += 2) {
                    if (isValid(row1 + d, col1, n, board) && isValid(row2 + d, col2, n, board)) {
                        if (!visited[0][row1][col1] || !visited[0][row2][col2]) {
                            visited[0][row1][col1] = true;
                            visited[0][row2][col2] = true;
                            q.add(new Robot(row1, col1, row1 + d, col1, 0, now.cnt + 1));
                            q.add(new Robot(row2, col2, row2 + d, col2, 0, now.cnt + 1));
                        }
                    }
                }
            } else { // 세로 → 가로 회전
                for (int d = -1; d <= 1; d += 2) {
                    if (isValid(row1, col1 + d, n, board) && isValid(row2, col2 + d, n, board)) {
                        if (!visited[1][row1][col1] || !visited[1][row2][col2]) {
                            visited[1][row1][col1] = true;
                            visited[1][row2][col2] = true;
                            q.add(new Robot(row1, col1, row1, col1 + d, 1, now.cnt + 1));
                            q.add(new Robot(row2, col2, row2, col2 + d, 1, now.cnt + 1));
                        }
                    }
                }
            }
        }

        return 0;
    }

    private boolean isValid(int r, int c, int n, int[][] board) {
        return r >= 0 && c >= 0 && r < n && c < n && board[r][c] == 0;
    }

    static class Robot {
        int row1, col1, row2, col2;
        int dir; // 0: 세로, 1: 가로
        int cnt;

        public Robot(int row1, int col1, int row2, int col2, int dir, int cnt) {
            this.row1 = row1;
            this.col1 = col1;
            this.row2 = row2;
            this.col2 = col2;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}