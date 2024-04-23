import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int size = (int)Math.pow(2, n);
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '*';
            }
        }

        if (n == 0) {
            System.out.println('*');
        } else {
            printStar(board, n, 0, 0, 1);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - i; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void printStar(char[][] board, int n, int x, int y, int type) {
        if (n == 1) {
            if (type == 1) {
                board[x + 1][y + 1] = ' ';
            } else {
                board[x][y] = ' ';
                board[x][y + 1] = ' ';
                board[x + 1][y] = ' ';
                board[x + 1][y + 1] = ' ';
            }
            return;
        }

        int pow = (int) Math.pow(2, n);
        int mid = pow / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 1 && j == 1) {
                    printStar(board, n - 1, mid * i + x, mid * j + y, 0);
                } else {
                    if (type == 0) {
                        printStar(board, n - 1, mid * i + x, mid * j + y, 0);
                    } else {
                        printStar(board, n - 1, mid * i + x, mid * j + y, 1);
                    }
                }
            }
        }

    }
}
