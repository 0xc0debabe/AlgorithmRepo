import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = {"..R", "...", "...", "..D", "DG."};
        System.out.println(sol.solution(arr));
    }

    public int solution(String[] board) {
        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    startRow = i;
                    startCol = j;
                } else if (map[i][j] == 'G') {
                    endRow = i;
                    endCol = j;
                }
            }
        }

        int[][] isVisited = new int[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Robot> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = startRow + dx[i];
            int ny = startCol + dy[i];

            if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= m - 1 && map[nx][ny] != 'D') {
                queue.add(new Robot(nx, ny, 1, i));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = Integer.MAX_VALUE;
            }
        }
        isVisited[startRow][startCol] = 1;
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Robot now = queue.poll();

            int nx = now.row + dx[now.dir];
            int ny = now.col + dy[now.dir];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 'D') {
                if (now.row == endRow && now.col == endCol) {
                    answer = Math.min(answer, now.moveCnt);
                }

                if (isVisited[now.row][now.col] > now.moveCnt) {
                    isVisited[now.row][now.col] = now.moveCnt + 1;

                    for (int i = 0; i < 4; i++) {
                        if (
                                (i == 0 && now.dir == 1) ||
                                (i == 1 && now.dir == 0) ||
                                (i == 2 && now.dir == 3) ||
                                (i == 3 && now.dir == 2)) {
                            continue;
                        }

                        int nnx = now.row + dx[i];
                        int nny = now.col + dy[i];

                        if (nnx >= 0 && nny >= 0 && nnx <= n - 1 && nny <= m - 1 && map[nnx][nny] != 'D') {
                            queue.add(new Robot(nnx, nny, now.moveCnt + 1, i));
                        }
                    }
                }

                continue;
            }

            queue.add(new Robot(nx, ny, now.moveCnt, now.dir));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    static class Robot {
        private int row;
        private int col;
        private int moveCnt;
        private int dir;

        public Robot(int row, int col, int moveCnt, int dir) {
            this.row = row;
            this.col = col;
            this.moveCnt = moveCnt;
            this.dir = dir;
        }
    }

}