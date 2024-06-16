import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static boolean[][] isVisited;
    static int m, n;
    static StringBuilder sb = new StringBuilder();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    board[j][l] = 1;
                }
            }
        }


        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer = 0;
                dfs(i, j);
                if (answer > 0) {
                    cnt++;
                    list.add(answer);
                }
            }
        }

        list.sort(Comparator.comparingInt(x -> x));
        sb.append(cnt).append("\n");
            for (int v : list) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= m || board[x][y] == 1 || isVisited[x][y]) {
            return;
        }

        isVisited[x][y] = true;
        answer++;
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x -1, y);
        dfs(x, y - 1);
    }
}