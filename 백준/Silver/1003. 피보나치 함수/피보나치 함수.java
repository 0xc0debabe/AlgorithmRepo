import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dp = new int[41];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= 40; i++) {
            fibonacci(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0){
                sb.append(1).append(" ").append(0).append("\n");
                continue;
            }
            sb.append(dp[num - 1]).append(" ").append(dp[num]).append("\n");
        }

        System.out.println(sb);
    }

    static int fibonacci(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        return dp[n] = fibonacci(n - 2) + fibonacci(n - 1);
    }
}