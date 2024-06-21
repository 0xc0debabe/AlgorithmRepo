import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (i == n && j == n) break;
                board[i][j] = Integer.parseInt(st.nextToken());
                int row = i + board[i][j];
                int col = j + board[i][j];

                if (row <= n) {
                    dp[row][j] += dp[i][j];
                }
                if (col <= n) {
                    dp[i][col] += dp[i][j];
                }
            }
        }


     System.out.println(dp[n][n]);
    }
}