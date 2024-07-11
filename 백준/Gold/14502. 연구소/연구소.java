import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] board;
    static int n, m, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) list.add(new Node(i, j));
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == 3) {
            bfs(copyArr());
            return;
        }

        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (board[r][c] == 0) {
                board[r][c] = 1;
                dfs(depth + 1, i + 1);
                board[r][c] = 0;
            }
        }
    }

    static void bfs(int[][] dupArr) {
        Queue<Node> queue = new LinkedList<>(list);

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int row = poll.row;
            int col = poll.col;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && dupArr[nx][ny] == 0) {
                    dupArr[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dupArr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, cnt);
    }

    static int[][] copyArr() {
        int[][] dupArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(board[i], 0, dupArr[i], 0, m);
        }

        return dupArr;
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}