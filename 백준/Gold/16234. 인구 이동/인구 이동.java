import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.PolicyQualifierInfo;
import java.util.*;


public class Main {
    static int[][] board;
    static boolean[][] isVisited;
    static List<Node> save;
    static int n, l, u, answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        answer = 0;


        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        boolean flag = false;
        while (!flag) {
            save = new ArrayList<>();
            isVisited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!isVisited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            int cnt = 0;
            for (Node node : save) {
                if (board[node.row][node.col] == node.sum) {
                    cnt++;
                    continue;
                }
                board[node.row][node.col] = node.sum;
            }
            if (cnt == n * n) {
                flag = true;
            } else {
                answer++;
            }

        }


        System.out.println(answer);
    }

    static void bfs(int row, int col) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 0));
        isVisited[row][col] = true;
        int totalSum = board[row][col];

        Queue<Node> save2 = new LinkedList<>();
        save2.add(new Node(row, col, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int r = poll.row;
            int c = poll.col;

            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !isVisited[nx][ny]) {
                    int tmp = Math.abs(board[nx][ny] - board[r][c]);

                    if (l <= tmp && tmp <= u) {
                        isVisited[nx][ny] = true;
                        save2.add(new Node(nx, ny, 0));
                        queue.add(new Node(nx, ny, 0));
                        totalSum += board[nx][ny];
                    }
                }
            }
        }

        if (!save2.isEmpty()) {
            totalSum /= save2.size();
            while (!save2.isEmpty()) {
                Node poll = save2.poll();
                save.add(new Node(poll.row, poll.col, totalSum));
            }
        }


    }
}

class Node {
    int row;
    int col;
    int sum;

    public Node(int row, int col, int sum) {
        this.row = row;
        this.col = col;
        this.sum = sum;
    }
}
