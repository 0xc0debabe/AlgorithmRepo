import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int size = Integer.parseInt(br.readLine());
            int[][] board = new int[2][size + 1];
            int[][] dp = new int[2][size + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= size; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = board[0][1];
            dp[1][1] = board[1][1];
            for (int j = 2; j <= size; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + board[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + board[1][j];
            }

            sb.append(Math.max(dp[0][size], dp[1][size])).append("\n");
        }
        System.out.println(sb);
    }
}
