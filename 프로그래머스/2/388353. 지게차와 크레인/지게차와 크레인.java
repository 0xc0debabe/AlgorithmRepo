import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s1 = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] r1 = {"A", "BB", "A"};
        String[] s2 = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] r2 = {"C", "B", "B", "B", "B", "H"};
        System.out.println(sol.solution(s1, r1));
        System.out.println(sol.solution(s2, r2));
    }


    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();
        String[][] board = new String[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                String[] split = storage[i].split("");
                board[i][j] = split[j];
            }
        }

        boolean[][][] canAccess = new boolean[2][n][m];
        for (int i = 0; i < n; i++) {
            canAccess[0][i][0] = true;
            canAccess[0][i][m - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            canAccess[0][0][i] = true;
            canAccess[0][n - 1][i] = true;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (String request : requests) {
            List<int[]> list = new ArrayList<>();
            if (request.length() == 1) {

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {

                        if (canAccess[0][i][j]) {
                            if (request.equals(board[i][j])) {
                                board[i][j] = ".";
                                list.add(new int[]{i, j});
                            }
                        }

                    }
                }

            } else {
                request = request.substring(1);

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (request.equals(board[i][j])) {
                            board[i][j] = ".";

                            if (canAccess[0][i][j]) {
                                list.add(new int[]{i, j});
                            } else {
                                canAccess[1][i][j] = true;
                            }
                        }

                    }
                }

            }

            for (int[] ints : list) {
                changeAccessZone(ints[0], dx , ints[1], dy, n, m, canAccess);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j].equals(".")) cnt++;
            }
        }
        return cnt;
    }

    private static void changeAccessZone(int i, int[] dx, int j, int[] dy, int n, int m, boolean[][][] canAccess) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!canAccess[0][nx][ny]) {
                    canAccess[0][nx][ny] = true;
                    if (canAccess[1][nx][ny]) {
                        // Only recurse if this cell is "locked" by crane
                        changeAccessZone(nx, dx, ny, dy, n, m, canAccess);
                    }
                }
            }
        }
    }
//    private static void changeAccessZone(int i, int[] dx, int j, int[] dy, int n, int m, boolean[][][] canAccess) {
//        for (int k = 0; k < 4; k++) {
//            int nx = i + dx[k];
//            int ny = j + dy[k];
//
//            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
//                canAccess[0][nx][ny] = true;
//                if (canAccess[1][nx][ny]) {
//                    changeAccessZone(nx, dx, ny, dy, n, m, canAccess);
//                }
//            }
//
//        }
//    }


}