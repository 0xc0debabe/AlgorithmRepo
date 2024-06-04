import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int cnt;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            board = new int[n][m];

            for (int j = 1; j <= k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (board[j][l] == 0) continue;
                    dfs(j, l, n, m);
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x > n - 1 || y > m - 1 || board[x][y] == 0) {
            return;
        }

        board[x][y] = 0;

        dfs(x + 1, y, n, m);
        dfs(x - 1, y, n, m);
        dfs(x, y + 1, n, m);
        dfs(x, y - 1, n, m);
    }
}