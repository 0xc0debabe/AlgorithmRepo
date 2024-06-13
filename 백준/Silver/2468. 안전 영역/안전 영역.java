import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] dupBoard;
    static int[] direction = {-1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(board[i][j], max);
            }
        }

        int answer = 0;
        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            dupBoard = new int[n + 1][n + 1];

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    dupBoard[j][k] = board[j][k] - i;
                }
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (dfs(j, k, n)) cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    static boolean dfs(int x, int y, int n) {
        if (x <= 0 || y <= 0 || x > n || y > n || dupBoard[x][y] <= 0) {
            return false;
        }

        dupBoard[x][y] = 0;

        for (int dir : direction) {
            dfs(x + dir, y, n);
            dfs(x, y + dir, n);
        }

        return true;
    }
}