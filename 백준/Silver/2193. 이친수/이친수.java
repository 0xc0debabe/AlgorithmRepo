import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 3];
        dp[1] = 1;
        dp[2] = 1;

        fib(n);
        System.out.println(dp[n]);
    }

    static long fib(int n) {
        if (n == 0) return 0;
        if (dp[n] > 0) {
            return dp[n];
        }

        return dp[n] = fib(n - 1) + fib(n - 2);
    }
}