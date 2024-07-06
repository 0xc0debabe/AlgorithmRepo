import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[][] board;
    static boolean[][] isVisited;
    static int n, m, wolf, sheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = split[j];
                if (board[i][j].equals("#")) isVisited[i][j] = true;
            }
        }

        int totalWolf = 0;
        int totalSheep = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                wolf = 0; sheep = 0;
                dfs(i, j);
                if (wolf >= sheep) totalWolf += wolf;
                else totalSheep += sheep;
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m || isVisited[row][col]) {
            return;
        }

        if (board[row][col].equals("v")) {
            wolf++;
        } else if (board[row][col].equals("o")) {
            sheep++;
        }
        isVisited[row][col] = true;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
