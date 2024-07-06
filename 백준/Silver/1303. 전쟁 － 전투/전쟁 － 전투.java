import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[][] board;
    static boolean[][] isVisited;
    static int n, m, wP, bP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        board = new String[n][m];
        isVisited = new boolean[n][m];
        wP = 0; bP = 0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = split[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = dfs(i, j,  board[i][j]);
                if (board[i][j].equals("W")) wP += (int) Math.pow(num, 2);
                else bP += (int) Math.pow(num, 2);
            }
        }
        System.out.println(wP + " " + bP);
    }

    static int dfs(int row, int col, String target) {
        if (row < 0 || col < 0 || row >= n || col >= m || isVisited[row][col] || !target.equals(board[row][col])) {
            return 0;
        }

        isVisited[row][col] = true;
        int sum = 1;

        sum += dfs(row + 1, col, target);
        sum += dfs(row - 1, col, target);
        sum += dfs(row, col + 1, target);
        sum += dfs(row, col - 1, target);

        return sum;
    }
}
