import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    max = Math.max(max, findMax(n, m, board, i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int findMax(int n, int m, int[][] board, int row, int col) {
        int max = 0;
        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        Queue<Shark> q = new LinkedList<>();
        q.add(new Shark(row, col, 1));
        boolean[][] visited = new boolean[n][m];
        visited[row][col] = true;
        int[][] test = new int[n][m];
        while (!q.isEmpty()) {
            Shark shark = q.poll();
            max = Math.max(max, shark.cnt);
            boolean flag = false;
            test[shark.r][shark.c] = shark.cnt;

            for (int i = 0; i < 8; i++) {
                int nr = shark.r + dx[i];
                int nc = shark.c + dy[i];
                if (inRange(nr, nc, n, m) && !visited[nr][nc]) {
                    if (board[nr][nc] == 1) {
                        flag = true;
                        break;
                    }
                    q.add(new Shark(nr, nc, shark.cnt + 1));
                    visited[nr][nc] = true;
                }
            }

            if (flag) break;
        }

        return max;
    }

    private static boolean inRange(int nr, int nc, int n, int m) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }

    static class Shark {
        int r, c, cnt;

        public Shark(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}