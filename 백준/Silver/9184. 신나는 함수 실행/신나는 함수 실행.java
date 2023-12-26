import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        while (true) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(function(a, b, c)).append("\n");
        }
        System.out.print(sb);
    }

    static int function(int a, int b, int c) {

        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
           return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = function(20, 20, 20);
        }

        if (a < b && b < c) {
            return dp[a][b][c] = function(a, b, c - 1) + function(a, b - 1, c - 1) - function(a, b - 1, c);
        }

        else {
            return dp[a][b][c] = function(a - 1, b, c) + function(a - 1, b - 1, c) + function(a - 1, b, c - 1) - function(a - 1, b - 1, c - 1);
        }
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}