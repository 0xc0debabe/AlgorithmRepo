import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String[][] board, copy;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            System.arraycopy(split, 0, board[i], 0, split.length);
        }

        int rg = 0;
        int r = 0;
        int g = 0;
        int b = 0;

        copyArr();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (findRG(i, j, copy)) {
                    rg++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (findR(i, j)) {
                    r++;
                } else if (findG(i, j)) {
                    g++;
                } else if (findB(i, j)) {
                    b++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(r + g + b).append(" ").append(rg + b);
        System.out.println(sb);
    }


    static boolean findRG(int row, int col, String[][] dupArr) {
        if (dupArr[row][col].equals("X") || dupArr[row][col].equals("B")) return false;

        dupArr[row][col] = "X";

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && (dupArr[nx][ny].equals("R") || dupArr[nx][ny].equals("G"))) {
                findRG(nx, ny, dupArr);
            }
        }

        return true;
    }

    static boolean findR(int row, int col) {
        if (!board[row][col].equals("R")) return false;
        board[row][col] = "X";

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny].equals("R")) {
                findR(nx, ny);
            }
        }

        return true;
    }

    static boolean findB(int row, int col) {
        if (!board[row][col].equals("B")) return false;
        board[row][col] = "X";


        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny].equals("B")) {
                findB(nx, ny);
            }
        }
        return true;
    }

    static boolean findG(int row, int col) {
        if (!board[row][col].equals("G")) return false;
        board[row][col] = "X";

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny].equals("G")) {
                findG(nx, ny);
            }
        }
        return true;
    }

    static void copyArr() {
        copy = new String[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, n);
        }

    }


}