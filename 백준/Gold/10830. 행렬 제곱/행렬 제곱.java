import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int n;
    static int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = fastPowMatrix(arr, b);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int[][] fastPowMatrix(int[][] matrix, long exp) {
        if (exp == 1L) return matrix;

        int[][] res = fastPowMatrix(matrix, exp / 2);

        res = multiply(res, res);

        if (exp % 2 == 1L) {
            res = multiply(res, arr);
        }

        return res;
    }

    static int[][] multiply(int[][] o1, int[][] o2) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += o1[i][k] * o2[k][j];
                    res[i][j] %= MOD;
                }
            }
        }

        return res;
    }
}
