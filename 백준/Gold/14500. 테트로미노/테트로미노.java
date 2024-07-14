import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int n, m, answer;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                type1(i, j);
                type2(i, j);
                type3(i, j);
                type4(i, j);
                type5(i, j);
            }
        }

        System.out.println(answer);
    }

    static void type1(int row, int col) {
        int nx = row + 3;
        int ny = col;
        int sum = 0;
        if (canCount(nx, ny)) {
            for (int i = row; i <= nx; i++) {
                sum += board[i][ny];
            }
        }
        answer = Math.max(answer, sum);

        nx = row;
        ny = col + 3;
        sum = 0;
        if (canCount(nx, ny)) {
            for (int i = col; i <= ny; i++) {
                sum += board[nx][i];
            }
        }

        answer = Math.max(answer, sum);
    }

    static void type2(int row, int col) {
        int nx = row + 1;
        int ny = col + 1;
        int sum = 0;
        if (canCount(nx, ny)) {
            for (int i = row; i <= nx; i++) {
                for (int j = col; j <= ny; j++) {
                    sum += board[i][j];
                }
            }
        }

        answer = Math.max(answer, sum);
    }

    static void type3(int row, int col) {
        int nx = row + 2;
        int ny = col + 1;
        int sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row + 1][col];
            sum += board[row + 2][col];
            sum += board[row + 2][col + 1];
        }

        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row][col + 2];
            sum += board[row + 1][col];
        }

        answer = Math.max(answer, sum);

        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col + 1];
        }

        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col + 2];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 1][col + 2];
        }

        answer = Math.max(answer, sum);

        ////////////////////////
        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col + 1];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col + 1];
            sum += board[row + 2][col];
        }

        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 1][col + 2];
        }

        answer = Math.max(answer, sum);

        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row + 1][col];
            sum += board[row + 2][col];
        }

        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row][col + 2];
            sum += board[row + 1][col + 2];
        }

        answer = Math.max(answer, sum);
    }

    static void type4(int row, int col) {
        int nx = row + 2;
        int ny = col + 1;
        int sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col + 1];
        }

         answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col + 1];
            sum += board[row][col + 2];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
        }

        answer = Math.max(answer, sum);

        ///////////////////////////////
        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col + 1];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col];
        }

        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row + 1][col + 1];
            sum += board[row + 1][col + 2];
        }

        answer = Math.max(answer, sum);

    }

    static void type5(int row, int col) {
        int nx = row + 1;
        int ny = col + 2;
        int sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col + 1];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 1][col + 2];
        }
        answer = Math.max(answer, sum);


        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row + 1][col];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col];
        }
        answer = Math.max(answer, sum);

        nx = row + 1;
        ny = col + 2;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row][col];
            sum += board[row][col + 1];
            sum += board[row][col + 2];
            sum += board[row + 1][col + 1];
        }
        answer = Math.max(answer, sum);

        nx = row + 2;
        ny = col + 1;
        sum = 0;
        if (canCount(nx, ny)) {
            sum += board[row + 1][col];
            sum += board[row][col + 1];
            sum += board[row + 1][col + 1];
            sum += board[row + 2][col + 1];
        }
        answer = Math.max(answer, sum);

    }

    static boolean canCount(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            return true;
        }

        return false;
    }
}