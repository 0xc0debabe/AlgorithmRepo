import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] board = {
                "CCBDE",
                "AAADE",
                "AAABF",
                "CCBBF"
        };
        System.out.println(solution.solution(4, 5, board));
    }

    int[] dc = {1, 0, 1};
    int[] dr = {0, 1, 1};
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m + 1][n];
        for (int i = 0; i < n; i++) {
            map[0][i] = '@';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i - 1].charAt(j);
            }
        }

        while (true) {
            List<int[]> destroy = new ArrayList<>();

            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    char target = map[i][j];
                    if (target == '@') continue;

                    if (findSameTarget(m, n, i, j, map, target)) {
                        addDestroyList(destroy, i, j);
                    }
                }
            }
            for (int[] ints : destroy) {
                int row = ints[0];
                int col = ints[1];
                map[row][col] = '!';
            }

            boolean isEnded = true;
            for (int i = 1; i <= m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '!') {
                        isEnded = false;
                        dfs(i, j, map);
                    }
                }
            }
            if (isEnded) break;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '@') {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void dfs(int row, int col, char[][] map) {
        if (row - 1 == 0){
            map[row][col] = map[row - 1][col];
            return;
        }

        map[row][col] = map[row - 1][col];
        dfs(row - 1, col, map);
    }

    private void addDestroyList(List<int[]> destroy, int i, int j) {
        destroy.add(new int[]{i, j});

        for (int k = 0; k < 3; k++) {
            int nr = dr[k] + i;
            int nc = dc[k] + j;

            destroy.add(new int[]{nr, nc});
        }
    }

    private boolean findSameTarget(int m, int n, int i, int j, char[][] map, char target) {
        boolean flag = true;

        for (int k = 0; k < 3; k++) {
            int nr = dr[k] + i;
            int nc = dc[k] + j;

            if (nr <= 0 || nc < 0 || nr > m || nc >= n || map[nr][nc] != target){
                flag = false;
                break;
            }
        }
        return flag;
    }

}



