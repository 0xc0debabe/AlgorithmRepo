import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] dp, prevNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[1000001];
        prevNum = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;
        prevNum[2] = 1;
        prevNum[3] = 1;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prevNum[i] = i - 1;

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    prevNum[i] = i / 3;
                }
            }
            
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    prevNum[i] = i / 2;
                }
            }
        }
        sb.append(dp[n]).append("\n");
        recursion(n);

        System.out.println(sb);
    }

    static int recursion(int a) {
        if (a == 0) return a;

        sb.append(a).append(" ");
        return recursion(prevNum[a]);
    }
}
