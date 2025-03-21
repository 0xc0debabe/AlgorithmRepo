import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] build = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };

//        int[][] build = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        int[][] solution1 = solution.solution(5, build);
        for (int[] ints : solution1) {
            System.out.print(ints[0] + " ");
            System.out.print(ints[1] + " ");
            System.out.println(ints[2]);
        }

    }

    boolean[][] gidoong;
    boolean[][] bo;
    public int[][] solution(int n, int[][] build_frame) {
        gidoong = new boolean[n + 1][n + 1];
        bo = new boolean[n + 1][n + 1];

        for (int[] frame : build_frame) {
            int row = frame[0];
            int col = frame[1];
            int structure = frame[2];
            int action = frame[3];

            if (isGidoong(structure)) {
                if (isInstall(action) && canInstallGidoong(row, col)) {
                    gidoong[row][col] = true;
                } else if (isRemove(action)){
                    gidoong[row][col] = false;
                    if (!canRemove(n)) gidoong[row][col] = true;
                }
            } else if (isBo(structure)) {
                if (isInstall(action) && canInstallBo(row, col, n)) {
                    bo[row][col] = true;
                } else if (isRemove(action)) {
                    bo[row][col] = false;
                    if (!canRemove(n)) bo[row][col] = true;
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (gidoong[i][j]) {
                    list.add(new int[]{i, j, 0});
                }
                if (bo[i][j]) {
                    list.add(new int[]{i, j, 1});
                }
            }
        }

        return list.stream().sorted((l1, l2) -> {
            if (l1[0] == l2[0]) {
                return l1[1] - l2[1];
            }
            return l1[0] - l2[0];
        }).toArray(int[][]::new);
    }

    private boolean canInstallGidoong(int row, int col) {
        if (col == 0) return true;
        if (col > 0 && gidoong[row][col - 1]) return true;
        if (row > 0 && bo[row - 1][col] || bo[row][col]) return true;
        return false;
    }

    private boolean canInstallBo(int row, int col, int n) {
        if (row > 0 && row <= n && (bo[row - 1][col] && bo[row + 1][col])) return true;
        if (col > 0 && gidoong[row][col - 1]) return true;
        if (row <= n && col > 0 && gidoong[row + 1][col - 1]) return true;
        return false;
    }

    private boolean canRemove(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (gidoong[i][j] && !canInstallGidoong(i, j)) return false;
                if (bo[i][j] && !canInstallBo(i, j, n)) return false;
            }
        }

        return true;
    }

    private boolean isRemove(int action) {
        return action == 0;
    }
    private boolean isInstall(int action) {
        return action == 1;
    }
    private boolean isBo(int structure) {
        return structure == 1;
    }
    private boolean isGidoong(int structure) {
        return structure == 0;
    }

}
