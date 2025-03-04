import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };

        solution.solution(6, 4, arr);
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    boolean[][] isVisited;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        isVisited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && picture[i][j] != 0) {
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int m, int n, int row, int col, int[][] picture) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        isVisited[row][col] = true;
        int target = picture[row][col];
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + now[0];
                int nc = dc[i] + now[1];

                if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                    if (!isVisited[nr][nc] && picture[nr][nc] == target) {
                        isVisited[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

}