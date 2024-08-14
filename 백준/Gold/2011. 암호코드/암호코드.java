import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();

        int[] dp = new int[charArray.length + 1];
        dp[0] = 1;
        for (int i = 1; i <= charArray.length; i++) {
            int a = charArray[i - 1] - '0';
            if (a >= 1 && a <= 9) {
                dp[i] = dp[i - 1];
            }

            if (i == 1) continue;
            int b = charArray[i - 2] - '0';
            int sum = b * 10 + a;
            if (sum >= 10 && sum <= 26) {
                dp[i] += dp[i - 2] % MOD;
            }
        }

        System.out.println(dp[charArray.length] % MOD);
    }
}
