import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static char[][] board;
    static boolean[] isVisited = new boolean[26];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            System.arraycopy(charArray, 0, board[i], 0, charArray.length);
        }

        isVisited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    static void dfs(int row, int col, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (!isVisited[board[nx][ny] - 'A']) {
                    isVisited[board[nx][ny] - 'A'] = true;
                    dfs(nx, ny, depth + 1);
                    isVisited[board[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}