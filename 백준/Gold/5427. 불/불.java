import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, startRow, startCol;
    static int answer;
    static List<Node> firePos;
    static boolean[][][] isVisited;
    static char[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            board = new char[n][m];
            isVisited = new boolean[2][n][m];
            firePos = new LinkedList<>();
            answer = 0;

            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                for (int k = 0; k < m; k++) {
                    board[j][k] = s.charAt(k);
                    if (board[j][k] == '@') {
                        startRow = j;
                        startCol = k;
                    } else if (board[j][k] == '*') {
                        firePos.add(new Node(j, k, '*', 0));
                    }
                }
            }

            bfs();
            if (answer == 0) {
                sb.append("IMPOSSIBLE").append('\n');
            } else {
                sb.append(answer).append('\n');
            }
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        for (Node fire : firePos) {
            queue.add(new Node(fire.row, fire.col, '*', 0));
            isVisited[0][fire.row][fire.col] = true;
        }
        queue.add(new Node(startRow, startCol, '@', 0));
        isVisited[1][startRow][startCol] = true;
        boolean flag = false;
        while (!queue.isEmpty()) {
            if (flag) break;
            Node now = queue.poll();
            int row = now.row;
            int col = now.col;

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (now.type == '*') {
                        if (!isVisited[0][nx][ny] && board[nx][ny] != '#') {
                            isVisited[0][nx][ny] = true;
                            board[nx][ny] = '*';
                            queue.add(new Node(nx, ny, '*', 0));
                        }

                    } else {
                        if (!isVisited[1][nx][ny] && board[nx][ny] == '.') {
                            isVisited[1][nx][ny] = true;
                            board[nx][ny] = '@';
                            queue.add(new Node(nx, ny, '@', now.cnt + 1));
                        }
                    }
                } else {
                    if (now.type == '@') {
                        answer = now.cnt + 1;
                        flag = true;
                        break;
                    }
                }
            }

        }
    }
}

class Node {
    int row;
    int col;
    int cnt;
    char type;

    public Node(int row, int col, char type, int cnt) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.cnt = cnt;
    }
}
