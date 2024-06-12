import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[10001];
        int answer = 0;
        dp[1] = arr[1];
        answer = Math.max(answer, dp[1]);


        if (n >= 2) {
            dp[2] = arr[2] + dp[1];
            answer = Math.max(answer, dp[2]);
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i]);
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}