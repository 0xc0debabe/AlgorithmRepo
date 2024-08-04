import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};

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
        int time = 0;
        int prevCheese = getCheese();

        while (true) {
            time++;
            isVisited = new boolean[n][m];
            bfs();
            int cheese = getCheese();
            if (cheese == 0) break;
            prevCheese = cheese;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append("\n").append(prevCheese);
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        isVisited[0][0] = true;
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int row = poll.row;
            int col = poll.col;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;

                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 2;
                    } else if (board[nx][ny] == 0) {
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static int getCheese() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1)  cnt++;
                else if (board[i][j] == 2) board[i][j] = 0;
            }
        }

        return cnt;
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