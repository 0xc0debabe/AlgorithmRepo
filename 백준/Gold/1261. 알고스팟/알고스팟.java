import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] board;
    static boolean[][] isVisited;
    static int m, n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        bfs(0, 0);
        System.out.println(answer);
    }

    static void bfs(int row, int col) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.wall - y.wall);
        pq.add(new Node(row, col, 0));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (poll.row == m - 1 && poll.col == n - 1) {
                answer = poll.wall;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.row + dx[i];
                int ny = poll.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !isVisited[nx][ny]) {
                    if (board[nx][ny] == 1) {
                        pq.add(new Node(nx, ny, poll.wall + 1));
                    } else {
                        pq.add(new Node(nx, ny, poll.wall));
                    }

                    isVisited[nx][ny] = true;
                }
            }
        }
    }
}

class Node {
    int row;
    int col;
    int wall;

    public Node(int row, int col, int wall) {
        this.row = row;
        this.col = col;
        this.wall = wall;
    }
}