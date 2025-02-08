import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] a = {
                {
                        "PXPXP",
                        "OXOXO",
                        "PXOXP",
                        "OXOXO",
                        "PXPXP"
                }
        };
        sol.solution(a);
    }

    char[][] board;
    boolean[][] isVisited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int k = 0; k < places.length; k++) {
            String[] place = places[k];

            int n = place.length;
            int m = place[0].length();

            board = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = place[i].charAt(j);
                }
            }

            boolean socialDist = true;
            for (int i = 0; i < n && socialDist; i++) {
                for (int j = 0; j < m && socialDist; j++) {
                    if (board[i][j] == 'P') {
                        isVisited = new boolean[n][m];
                        if (!isDistanceMaintain(i, j, n, m)) socialDist = false;
                    }
                }
            }

            if (socialDist) answer[k] = 1;
        }

        return answer;
    }

    private boolean isDistanceMaintain(int row, int col, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col, 0});
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];
            int dist = now[2];

            if (dist >= 2) continue;

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    if (board[nx][ny] == 'O') queue.add(new int[]{nx, ny, dist + 1});
                    if (board[nx][ny] == 'P') return false;
                }
            }

        }

        return true;
    }


}