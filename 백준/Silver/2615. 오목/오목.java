import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] board;
    static int whoWin = 0;
    static boolean[][][] isVisited = new boolean[9][20][20];
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[20][20];

        for (int i = 1; i <= 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp1 = 0;
        int tmp2 = 0;
        for (int j = 1; j <= 19; j++) {
            for (int i = 1; i <= 19; i++) {
                int wp = 1;
                if (board[i][j] == 2) wp = 2;
                dfs(i, j, 1, 0, 1, 0, wp);
                dfs(i, j, 0, 1, 2, 0, wp);
                dfs(i, j, 1, 1, 3, 0, wp);


                dfs(i, j, 1, -1, 4, 0, wp);
                dfs(i, j, 0, -1, 5, 0, wp);
                dfs(i, j, -1, -1, 6, 0, wp);

                dfs(i, j, -1, 0, 7, 0, wp);
                dfs(i, j, -1, 1, 8, 0, wp);

                if (check) {
                    tmp1 = i;
                    tmp2 = j;
                    break;
                }
            }
            if (check) break;
        }

        StringBuilder sb = new StringBuilder();
        if (check) {
            sb.append(whoWin).append("\n").append(tmp1).append(" ").append(tmp2);
        } else {
            sb.append(0);
        }

        System.out.println(sb);
    }

    static void dfs(int row, int col, int rowP, int colP, int type, int sum, int wp) {
        if (row >= 20 || col >= 20 || isVisited[type][row][col] || board[row][col] == 0 || wp != board[row][col] || check) {
            if (sum == 5){
                check = true;
                whoWin = wp;
            }

            return;
        }

        isVisited[type][row][col] = true;
        dfs(row + rowP, col + colP, rowP, colP, type, sum + 1, wp);
    }
}