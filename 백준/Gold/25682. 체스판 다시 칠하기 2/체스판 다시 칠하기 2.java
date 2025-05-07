import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String col = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = col.charAt(j);
                board[i][j] = c;
            }
        }

        int[][] wSum = new int[n + 1][m + 1];
        int[][] bSum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bSum[i + 1][j + 1] = bSum[i][j + 1] + bSum[i + 1][j] - bSum[i][j];
                wSum[i + 1][j + 1] = wSum[i][j + 1] + wSum[i + 1][j] - wSum[i][j];

                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1)) {
                    if (board[i][j] == 'W') {
                        bSum[i + 1][j + 1] += 1;
                    } else if (board[i][j] == 'B') {
                        wSum[i + 1][j + 1] += 1;
                    }
                } else {
                    if (board[i][j] == 'B') {
                        bSum[i + 1][j + 1] += 1;
                    } else {
                        wSum[i + 1][j + 1] += 1;
                    }
                }

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {

                int bMin = bSum[i][j] - bSum[i][j - k] - bSum[i - k][j] + bSum[i - k][j - k];
                int wMin = wSum[i][j] - wSum[i][j - k] - wSum[i - k][j] + wSum[i - k][j - k];
                min = Math.min(min, Math.min(bMin, wMin));
            }
        }

        System.out.println(min);
    }
}