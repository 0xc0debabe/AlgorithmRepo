import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] board;
    static int n, m;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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

        int answer = 0;
        while (true) {
            answer++;
            int sum = 0;
            isVisited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0) {
                        board[i][j] -= dfs(i, j);
                        if (board[i][j] > 0) {
                            sum += board[i][j];
                        }
                    }
                }
            }

            isVisited = new boolean[n][m];
            int glacierNum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > 0 && !isVisited[i][j]) {
                        glacierNum++;
                        bfs(i, j);
                    }
                }
            }

            if (glacierNum >= 2) {
                break;
            } else if (sum == 0) {
                answer = 0;
                break;
            }
        }
        System.out.println(answer);
    }

    static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));
        isVisited[row][col] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int r = now.row;
            int c = now.col;

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (board[nx][ny] > 0 && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    static int dfs(int row, int col) {
        int cnt = 0;
        isVisited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (board[nx][ny] <= 0 && !isVisited[nx][ny]) {
                    cnt++;
                }
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