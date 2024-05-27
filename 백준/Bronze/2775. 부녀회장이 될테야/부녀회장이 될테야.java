import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());


        for (int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int max = Math.max(a, b) + 1;
            int[][] dp = new int[max][max];

            for (int j = 1; j < max; j++) {
                dp[1][j] = j + dp[1][j - 1];
            }

            for (int j = 2; j < max; j++) {
                for (int k = 1; k < max; k++) {
                    dp[j][k] = dp[j][k - 1] + dp[j - 1][k];
                }
            }

            System.out.println(dp[a][b]);
        }

    }
}