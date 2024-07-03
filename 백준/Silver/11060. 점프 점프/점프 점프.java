import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = 1_000_000_000;

            for (int j = 1; j < i; j++) {
                if (arr[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }

        }
        if (dp[n] == 1_000_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}