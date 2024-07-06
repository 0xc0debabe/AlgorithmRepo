import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[][] board;
    static boolean[][] isVisited;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new String[n][m];
        isVisited = new boolean[n][m];
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = split[j];
                if (board[i][j].equals("X")) isVisited[i][j] = true;
                if (board[i][j].equals("I")) {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        dfs(startRow, startCol);
        System.out.println(answer == 0 ? "TT" : answer);
    }

    static void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m || isVisited[row][col]) return;

        isVisited[row][col] = true;
        if (board[row][col].equals("P")) answer++;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }

}
