import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        final int MAX = 10000;
        int[] dp = new int[MAX + 1];

        // dp[0] = 1 : "아무 것도 안 쓰는 방법"을 1로 둬야 누적이 제대로 됨
        dp[0] = 1;

        int[] coins = {1, 2, 3};
        // 조합을 세려면 "동전 바깥, 금액 안쪽" 순서로 누적
        for (int c : coins) {
            for (int i = c; i <= MAX; i++) {
                dp[i] += dp[i - c];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb.toString());
    }
}