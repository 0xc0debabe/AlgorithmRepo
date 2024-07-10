import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int[][] board;
    static List<Node> list = new ArrayList<>();
    static int n, m, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

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
                if (board[i][j] == 2) {
                    list.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int idx) {
        if (depth == 3) {
            bfs(arrCopy());
            return;
        }

        for (int i = idx; i < n * m; i++) {
            int row = i / m;
            int col = i % m;

            if (board[row][col] == 0) {
                board[row][col] = 1;
                dfs(depth + 1, i + 1);
                board[row][col] = 0;
            }
        }

    }

    static void bfs(int[][] dupBoard) {
        Queue<Node> queue = new LinkedList<>();
        for (Node node : list) {
            queue.add(new Node(node.row, node.col));
        }

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.row + dx[i];
                int ny = poll.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && dupBoard[nx][ny] == 0) {
                    dupBoard[nx][ny] = 2;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dupBoard[i][j] == 0) {
                    cnt++;
                }
            }
        }

        answer = Math.max(answer, cnt);
    }

    static int[][] arrCopy() {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = board[i][j];
            }
        }

        return copy;
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