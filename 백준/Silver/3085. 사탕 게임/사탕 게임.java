import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    static boolean[][] isVisited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        int max;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char standard = board[i][j];

                if (j < n - 1) {
                    char right = board[i][j + 1];
                    board[i][j] = right;
                    board[i][j + 1] = standard;
                    max = Math.max(findMaxUD(i, j, board[i][j]), findMaxLR(i, j, board[i][j]));
                    answer = Math.max(answer, max);
                    board[i][j] = standard;
                    board[i][j + 1] = right;
                }

                if (j >= 1) {
                    char left = board[i][j - 1];
                    board[i][j] = left;
                    board[i][j - 1] = standard;
                    max = Math.max(findMaxUD(i, j, board[i][j]), findMaxLR(i, j, board[i][j]));
                    answer = Math.max(answer, max);
                    board[i][j] = standard;
                    board[i][j - 1] = left;
                }


                if (i < n - 1) {
                    char down = board[i + 1][j];
                    board[i][j] = down;
                    board[i + 1][j] = standard;
                    max = Math.max(findMaxUD(i, j, board[i][j]), findMaxLR(i, j, board[i][j]));
                    answer = Math.max(answer, max);
                    board[i][j] = standard;
                    board[i + 1][j] = down;
                }

                if (i >= 1) {
                    char up = board[i - 1][j];
                    board[i][j] = up;
                    board[i - 1][j] = standard;
                    max = Math.max(findMaxUD(i, j, board[i][j]), findMaxLR(i, j, board[i][j]));
                    answer = Math.max(answer, max);
                    board[i][j] = standard;
                    board[i - 1][j] = up;
                }
            }
        }

        System.out.println(answer);
    }

    static int findMaxUD(int row, int col, char now) {
        if (row < 0 || col < 0 || row >= n || col >= n || now != board[row][col] || isVisited[row][col]) {
            return 0;
        }

        int sum = 1;
        isVisited[row][col] = true;
        sum += findMaxUD(row + 1, col, now);
        sum += findMaxUD(row - 1, col, now);
        isVisited[row][col] = false;
        return sum;
    }

    static int findMaxLR(int row, int col, char now) {
        if (row < 0 || col < 0 || row >= n || col >= n || now != board[row][col] || isVisited[row][col]) {
            return 0;
        }

        int sum = 1;
        isVisited[row][col] = true;
        sum += findMaxLR(row, col + 1, now);
        sum += findMaxLR(row, col - 1, now);
        isVisited[row][col] = false;
        return sum;
    }
}