import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int len = 4 * (n - 1) + 1;
        char[][] board = new char[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                board[i][j] = ' ';
            }
        }

        printStarts(board, 0, 0, len, n);
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    static void printStarts(char[][] board, int x, int y, int size, int n) {
        if (n == 1) {
            board[x][y] = '*';
            return;
        }

        for (int i = x; i < size + x; i++) {
            board[i][x] = '*';
            board[i][size + x - 1] = '*';
        }

        for (int i = y; i < size + y; i++) {
            board[y][i] = '*';
            board[size + y - 1][i] = '*';
        }

        int newSize = 4 * (n - 2) + 1;
        printStarts(board, x + 2, y + 2, newSize, n - 1);
    }
}
