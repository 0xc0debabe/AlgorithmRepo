import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n, m, k;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row - 1][col - 1] = 1;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }
        System.out.println(answer);
    }

    static int dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m || board[row][col] == 0) {
            return 0;
        }
        board[row][col] = 0;
        int sum = 1;
        sum += dfs(row + 1, col);
        sum += dfs(row - 1, col);
        sum += dfs(row, col + 1);
        sum += dfs(row, col - 1);

        return sum;
    }
}