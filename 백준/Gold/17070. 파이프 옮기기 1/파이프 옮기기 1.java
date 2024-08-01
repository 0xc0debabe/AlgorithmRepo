import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] board;
    static int n;
    static int answer = 0;
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        board[0][0] = 2; board[0][1] = 2;
        dfs(0, 1);
        System.out.println(answer);
    }

    static void dfs(int row, int col) {
        if (row == n - 1 && col == n - 1) {
            answer++;
        }

        if (board[row][col - 1] == 2) { // 가로일 때
            if (canMoveGaro(row, col)) {
                board[row][col - 1] = 0;
                board[row][col + 1] = 2;
                dfs(row, col + 1);
                board[row][col - 1] = 2;
                board[row][col + 1] = 0;
            }

            if (canMoveDaeGak(row, col)) {
                board[row][col - 1] = 0;
                board[row + 1][col + 1] = 2;
                dfs(row + 1, col + 1);
                board[row][col - 1] = 2;
                board[row + 1][col + 1] = 0;
            }
        } else if (board[row - 1][col] == 2) { // 세로일 때
            if (canMoveSero(row, col)) {
                board[row - 1][col] = 0;
                board[row + 1][col] = 2;
                dfs(row + 1, col);
                board[row - 1][col] = 2;
                board[row + 1][col] = 0;
            }

            if (canMoveDaeGak(row, col)) {
                board[row - 1][col] = 0;
                board[row + 1][col + 1] = 2;
                dfs(row + 1, col + 1);
                board[row - 1][col] = 2;
                board[row + 1][col + 1] = 0;
            }
        } else if (board[row - 1][col - 1] == 2){ // 대각일 때
            if (canMoveGaro(row, col)) {
                board[row - 1][col - 1] = 0;
                board[row][col + 1] = 2;
                dfs(row, col + 1);
                board[row - 1][col - 1] = 2;
                board[row][col + 1] = 0;
            }

            if (canMoveSero(row, col)) {
                board[row - 1][col - 1] = 0;
                board[row + 1][col] = 2;
                dfs(row + 1, col);
                board[row - 1][col - 1] = 2;
                board[row + 1][col] = 0;
            }

            if (canMoveDaeGak(row, col)) {
                board[row - 1][col - 1] = 0;
                board[row + 1][col + 1] = 2;
                dfs(row + 1, col + 1);
                board[row - 1][col - 1] = 2;
                board[row + 1][col + 1] = 0;
            }
        }
    }

    static boolean canMoveGaro(int row, int col) {
        return col + 1 < n && board[row][col + 1] != 1;
    }

    static boolean canMoveSero(int row, int col) {
        return row + 1 < n && board[row + 1][col] != 1;
    }

    static boolean canMoveDaeGak(int row, int col) {
        for (int i = 0; i < 3; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= n || ny >= n || board[nx][ny] == 1) {
                return false;
            }
        }

        return true;
    }
}