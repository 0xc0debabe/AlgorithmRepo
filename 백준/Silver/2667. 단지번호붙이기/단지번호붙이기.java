import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static List<Integer> list = new ArrayList<>();
    static int[] dirX = {1, -1};
    static int[] dirY = {1, -1};
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < split.length; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) continue;
                cnt = 0;
                dfs(i, j, n);
                if (cnt > 0) list.add(cnt);
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int l : list) {
            sb.append(l).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int n) {
        if (x < 0 || x > n - 1 || y < 0 || y > n - 1 || board[x][y] == 0) {
            return;
        }

        board[x][y] = 0;
        cnt++;
        for (int dx : dirX) {
            dfs(x + dx , y, n);
        }

        for (int dy : dirY) {
            dfs(x , y + dy, n);
        }
    }
}