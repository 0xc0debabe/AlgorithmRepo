import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int n, m;
    static int answer, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp = 0;
                if (dfs(i, j, 0, 0)) {
                    answer = Math.max(answer, tmp);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);
    }

    static boolean dfs(int x, int y, int depth, int sum) {
        if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 0) {
            return false;
        }

        board[x][y] = 0;
        tmp++;
        dfs(x + 1, y, depth + 1, sum + 1);
        dfs(x - 1, y, depth + 1, sum + 1);
        dfs(x, y + 1, depth + 1, sum + 1);
        dfs(x, y - 1, depth + 1, sum + 1);
        return true;
    }
}
