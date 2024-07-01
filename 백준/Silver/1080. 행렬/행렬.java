import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] board, targetBoard;
    static int n, m;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        targetBoard = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                targetBoard[i][j] = Integer.parseInt(split[j]);
            }
        }

        if (n >= 3 && m >= 3) {
            dfs(0, 0);
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == targetBoard[i][j]) {
                    cnt++;
                }
            }
        }
        if (cnt == n * m) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    static void dfs(int row, int col) {
        if (col >= m - 2) {
            dfs(row + 1, 0);
            return;
        }

        if (row >= n - 2) {
            return;
        }

        if (board[row][col] != targetBoard[row][col]) {
            answer++;

            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] == 1) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                }
            }
        }

        dfs(row, col + 1);
    }
}