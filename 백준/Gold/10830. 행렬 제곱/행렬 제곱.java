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

        int[][] ints = matrixFastPow(b);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ints[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int[][] matrixFastPow(long b) {
        if (b == 1) {
            return arr;
        }

        int[][] result = matrixFastPow(b / 2);

        result = matrixMultiply(result, result);

        if (b % 2 == 1) {
            result = matrixMultiply(result, arr);
        }

        return result;
    }

    static int[][] matrixMultiply(int[][] o1, int[][] o2) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += (o1[i][k] * o2[k][j]) % MOD;
                    result[i][j] %= MOD;
                }
            }
        }

        return result;
    }
}
