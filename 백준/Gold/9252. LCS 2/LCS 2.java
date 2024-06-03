import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dp[a.length][b.length]).append("\n");
        getText(a.length, b.length, a, b, dp);
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }

    private static void getText(int i, int j, char[] a, char[] b, int[][] dp) {
        if (i == 0 || j == 0) return;
        if (a[i - 1] == b[j - 1]) {
            list.add(a[i - 1]);
            getText(i - 1, j - 1, a, b, dp);
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                getText(i - 1, j, a, b, dp);
            } else {
                getText(i, j - 1, a, b, dp);
            }
        }
    }
}