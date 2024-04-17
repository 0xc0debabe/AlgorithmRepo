import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] arrSum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arrSum[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int[][] arrSum2 = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arrSum2[i][j] = arrSum2[i][j - 1] + arrSum2[i - 1][j] - arrSum2[i - 1][j - 1] + arrSum[i][j];
            }
        }


        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            int result = arrSum2[x2][y2] - arrSum2[x1 - 1][y2] - arrSum2[x2][y1 - 1] + arrSum2[x1 - 1][y1 - 1];
            System.out.println(result);
        }


    }
}