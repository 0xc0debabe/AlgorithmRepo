
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        System.out.println(sol.solution(maps));
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] isVisited = new boolean[n][m];
        int[][] dist = new int[n][m];

        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        isVisited[0][0] = true;
        while (!queue.isEmpty()) {
            Pos poll = queue.poll();
            int row = poll.row;
            int col = poll.col;

            if (row == n - 1 && col == m - 1){
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + row;
                int ny = dy[i] + col;

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !isVisited[nx][ny]) {
                    if (maps[nx][ny] == 1) {
                        isVisited[nx][ny] = true;
                        dist[nx][ny] = dist[row][col] + 1;
                        queue.add(new Pos(nx, ny));
                    }
                }
            }
        }

        if (dist[n - 1][m - 1] == 0) {
            return -1;
        }
        
        return dist[n - 1][m - 1] + 1;
    }

    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}