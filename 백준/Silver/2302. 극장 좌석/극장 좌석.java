import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[51];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int m = Integer.parseInt(br.readLine());
        int answer = 1;
        int prev = 0;
        for (int i = 0; i < m; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            answer *= dp[parseInt - 1 - prev];
            prev = parseInt;
        }

        if (prev != n) {
            answer *= dp[n - prev];
        }

        System.out.println(answer);
    }
}
