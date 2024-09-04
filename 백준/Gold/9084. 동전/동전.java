import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            // dp[i][j]는 처음 i종류의 동전을 사용하여 j원을 만드는 방법의 수
            int[][] dp = new int[N + 1][M + 1];

            // 0원을 만드는 방법은 1가지 (동전을 사용하지 않는 것)
            for (int i = 0; i <= N; i++) {
                dp[i][0] = 1;
            }

            // 동전 처리
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    dp[i][j] = dp[i - 1][j]; // 동전을 사용하지 않는 경우
                    if (j >= coins[i - 1]) {
                        dp[i][j] += dp[i][j - coins[i - 1]]; // 동전을 사용하는 경우
                    }
                }
            }

            sb.append(dp[N][M]).append('\n');
        }

        System.out.println(sb);
    }
}