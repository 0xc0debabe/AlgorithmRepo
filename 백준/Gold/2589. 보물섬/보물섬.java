import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] isVisited;
    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        answer = Integer.MIN_VALUE;
        isVisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'L') {
                    bfs(i, j);
                    setFalse();
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0));
        isVisited[r][c] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int row = poll.row;
            int col = poll.col;

            answer = Math.max(answer, poll.cnt);

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !isVisited[nx][ny]) {
                    if (board[nx][ny] == 'L') {
                        isVisited[nx][ny] = true;
                        queue.add(new Node(nx, ny, poll.cnt + 1));
                    }
                }
            }
        }
    }

    static void setFalse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isVisited[i][j] = false;
            }
        }
    }
}

class Node {
    int row;
    int col;
    int cnt;

    public Node(int row, int col, int cnt) {
        this.row = row;
        this.col = col;
        this.cnt = cnt;
    }
}