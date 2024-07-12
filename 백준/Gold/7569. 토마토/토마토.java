import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][][] board;
    static int m, n, h;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dh = {1, -1};
    static int zeroCnt = 0;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][n][m];

        for (int k = 0; k < h; k++) {

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                    if (board[k][i][j] == 1) {
                        list.add(new Node(k, i, j, 0));
                    } else if (board[k][i][j] == 0) {
                        zeroCnt++;
                    }
                }
            }
        }

        int totalTime = bfs();
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        cnt++;
                    }
                }
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
        } else if (cnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(totalTime);
        }
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (Node node : list) {
            queue.add(new Node(node.height, node.row, node.col, 0));
        }

        int max = 0;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int height = poll.height;
            int row = poll.row;
            int col = poll.col;
            int time = poll.time;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[height][nx][ny] == 0) {
                    queue.add(new Node(height, nx, ny, time + 1));
                    board[height][nx][ny] = 1;
                }
            }

            for (int i = 0; i < 2; i++) {
                int nh = height + dh[i];

                if (nh >= 0 && nh < h && board[nh][row][col] == 0) {
                    queue.add(new Node(nh, row, col, time + 1));
                    board[nh][row][col] = 1;
                }
            }

            max = Math.max(max, time);
        }

        return max;
    }
}

class Node {
    int height;
    int row;
    int col;
    int time;

    public Node(int height, int row, int col, int time) {
        this.height = height;
        this.row = row;
        this.col = col;
        this.time = time;
    }
}