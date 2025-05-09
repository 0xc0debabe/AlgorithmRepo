import java.io.*;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] matrix1 = getMatrix(a, b);

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] matrix2 = getMatrix(c, d);

        int[][] answer = matrixMultiply(matrix1, matrix2, a, b, c, d);
        StringBuilder sb = new StringBuilder();

        for (int[] ints : answer) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static int[][] getMatrix(int n, int m) throws IOException {
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return matrix;
    }

    private static int[][] matrixMultiply(int[][] m1, int[][] m2, int a, int b, int c, int d) {
        int[][] result = new int[a][d];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < d; j++) {
                int sum = 0;
                for (int k = 0; k < c; k++) {
                    sum += m1[i][k] * m2[k][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }
}