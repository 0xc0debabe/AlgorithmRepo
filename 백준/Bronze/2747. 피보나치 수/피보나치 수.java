import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 3];
        dp[1] = 1;
        dp[2] = 1;

        fib(n);
        System.out.println(dp[n]);
    }

    static int fib(int n) {
        if (n == 0) return 0;
        if (dp[n] > 0) {
            return dp[n];
        }

        return dp[n] = fib(n - 2) + fib(n - 1);
    }
}