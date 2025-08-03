import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int[] arr = new int[n + 1];
            int[] dp = new int[n + 1];
            for(int i = 0; i < n; i++) {
                arr[i + 1] = Integer.parseInt(br.readLine());
            }
            int max = Integer.MIN_VALUE;
            for(int i = 1; i <= n; i++) {
                if(dp[i - 1] + arr[i] > arr[i]) {
                    dp[i] = dp[i - 1] + arr[i];
                } else {
                    dp[i] = arr[i];
                }

                max = Math.max(max, dp[i]);
            }
            sb.append(max).append('\n');
        }

        System.out.println(sb);
    }
}