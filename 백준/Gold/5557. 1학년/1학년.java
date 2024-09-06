import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[][] dp = new long[n][21];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j <= 20; j++) {

                if (dp[i - 1][j] != 0) {

                    if (j + arr[i] <= 20) dp[i][j + arr[i]] += dp[i - 1][j];
                    if (j - arr[i] >= 0) dp[i][j - arr[i]] += dp[i - 1][j];

                }
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}
