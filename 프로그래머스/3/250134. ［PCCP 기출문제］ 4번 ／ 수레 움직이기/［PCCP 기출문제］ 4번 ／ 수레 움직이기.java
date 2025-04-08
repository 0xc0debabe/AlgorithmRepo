import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] maze1 = {{1, 4}, {0, 0}, {2, 3}};
        int[][] maze2 = {{1, 0, 2}, {0, 0, 0}, {5, 0, 5}, {4, 0, 3}};
        int[][] maze3 = {{1, 5}, {2, 5}, {4, 5}, {3, 5}};
        int[][] maze4 = {{4, 1, 2, 3}};
        System.out.println(solution.solution(maze1)); // 3
        System.out.println(solution.solution(maze2)); // 7
        System.out.println(solution.solution(maze3)); // 0
        System.out.println(solution.solution(maze4)); // 0
    }

    int[] dr = {-1, 1, 0, 0, 0}; // 상, 하, 좌, 우, 정지
    int[] dc = {0, 0, -1, 1, 0};

    int n, m;
    int[][] maze;
    boolean[][] redVisited;
    boolean[][] blueVisited;
    int redStartRow, redStartCol, redEndRow, redEndCol;
    int blueStartRow, blueStartCol, blueEndRow, blueEndCol;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] mazeInput) {
        this.maze = mazeInput;
        n = maze.length;
        m = maze[0].length;
        redVisited = new boolean[n][m];
        blueVisited = new boolean[n][m];

        // 시작 및 도착 위치 파악
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    redStartRow = i;
                    redStartCol = j;
                } else if (maze[i][j] == 2) {
                    blueStartRow = i;
                    blueStartCol = j;
                } else if (maze[i][j] == 3) {
                    redEndRow = i;
                    redEndCol = j;
                } else if (maze[i][j] == 4) {
                    blueEndRow = i;
                    blueEndCol = j;
                }
            }
        }

        redVisited[redStartRow][redStartCol] = true;
        blueVisited[blueStartRow][blueStartCol] = true;

        dfs(redStartRow, redStartCol, blueStartRow, blueStartCol, 0, false, false);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(int redRow, int redCol, int blueRow, int blueCol, int depth, boolean redFixed, boolean blueFixed) {
        if (redFixed && blueFixed) {
            answer = Math.min(answer, depth);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextRedRow = redFixed ? redRow : redRow + dr[i];
            int nextRedCol = redFixed ? redCol : redCol + dc[i];

            for (int j = 0; j < 4; j++) {
                int nextBlueRow = blueFixed ? blueRow : blueRow + dr[j];
                int nextBlueCol = blueFixed ? blueCol : blueCol + dc[j];

                if (!isValid(nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, redFixed, blueFixed)) continue;

                // 수레 교차 이동 불가
                if ((redRow == nextBlueRow && redCol == nextBlueCol) &&
                    (blueRow == nextRedRow && blueCol == nextRedCol)) continue;

                boolean nextRedFixed = redFixed || (nextRedRow == redEndRow && nextRedCol == redEndCol);
                boolean nextBlueFixed = blueFixed || (nextBlueRow == blueEndRow && nextBlueCol == blueEndCol);

                if (!nextRedFixed) redVisited[nextRedRow][nextRedCol] = true;
                if (!nextBlueFixed) blueVisited[nextBlueRow][nextBlueCol] = true;

                dfs(nextRedRow, nextRedCol, nextBlueRow, nextBlueCol, depth + 1, nextRedFixed, nextBlueFixed);

                if (!nextRedFixed) redVisited[nextRedRow][nextRedCol] = false;
                if (!nextBlueFixed) blueVisited[nextBlueRow][nextBlueCol] = false;
            }
        }
    }

    private boolean isValid(int rr, int rc, int br, int bc, boolean redFixed, boolean blueFixed) {
        if (outOfBounds(rr, rc) || outOfBounds(br, bc)) return false;
        if (maze[rr][rc] == 5 || maze[br][bc] == 5) return false; // 벽
        if (!redFixed && redVisited[rr][rc]) return false;
        if (!blueFixed && blueVisited[br][bc]) return false;
        if (rr == br && rc == bc) return false; // 같은 칸 이동 불가
        return true;
    }

    private boolean outOfBounds(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}