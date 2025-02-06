import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"SL", "LR"};
        solution.solution(s);
    }

    int n; int m;
    boolean[][][] isVisited;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};
    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
        isVisited = new boolean[4][n][m];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[d][i][j]) {
                        list.add(dfs(grid, d, i, j));
                    }
                }
            }
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

    private int dfs(String[] grid, int dir, int row, int col) {
        int cnt = 0;
        while (!isVisited[dir][row][col]) {
            cnt++;
            isVisited[dir][row][col] = true;
            if (grid[row].charAt(col) == 'L') {
                dir = (dir + 1) % 4;
            } else if (grid[row].charAt(col) == 'R') {
                dir = (dir + 3) % 4;
            }

            row = (row + dx[dir] + n) % n;
            col = (col + dy[dir] + m) % m;
        }

        return cnt;
    }

}