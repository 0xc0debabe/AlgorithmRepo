import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= split.length; j++) {
                int num = Integer.parseInt(split[j - 1]);
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + num;
            }
        }

        recursion(1, 1, n);
        System.out.println(sb);
    }

    static void recursion(int x, int y, int size) {
        if (size == 0) {
            return;
        }

        if (dp[x + size - 1][y + size - 1] - dp[x - 1][y + size - 1] - dp[x + size - 1][y - 1] + dp[x - 1][y - 1] == size * size) {
            sb.append(1);
        } else if (dp[x + size - 1][y + size - 1] - dp[x - 1][y + size - 1] - dp[x + size - 1][y - 1] + dp[x - 1][y - 1] == 0) {
            sb.append(0);
        } else {
            int newSize = size / 2;
            sb.append("(");
            recursion(x, y, newSize);
            recursion(x, y  + newSize, newSize);
            recursion(x + newSize, y, newSize);
            recursion(x  + newSize, y  + newSize, newSize);
            sb.append(")");
        }
    }
}

