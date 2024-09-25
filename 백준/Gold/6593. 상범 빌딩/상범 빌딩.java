import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][][] board;
    static int sl, sx, sy, l, r, c;
    static int[] dl = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;
            board = new char[l][r][c];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < c; k++) {
                        board[i][j][k] = s.charAt(k);
                        if (board[i][j][k] == 'S') {
                            sl = i;
                            sx = j;
                            sy = k;
                        }
                    }
                }
                br.readLine();
            }

            int bfs = bfs();
            if (bfs == -1) sb.append("Trapped!").append('\n');
            else sb.append("Escaped in ").append(bfs).append(" minute(s).").append('\n');
        }

        System.out.println(sb);
    }

    static int bfs() {
        boolean[][][] isVisited = new boolean[l][r][c];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sl, sx, sy, 0));
        isVisited[sl][sx][sy] = true;
        int answer = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (board[now.height][now.row][now.col] == 'E') {
                answer = now.footprint;
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nl = now.height + dl[i];
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (nl < 0 || nx < 0 || ny < 0 || nl >= l || nx >= r || ny >= c) continue;

                if (!isVisited[nl][nx][ny] && board[nl][nx][ny] != '#') {
                    isVisited[nl][nx][ny] = true;
                    queue.add(new Node(nl, nx, ny, now.footprint + 1));
                }
            }
        }

        return answer;
    }
}

class Node {
    int height;
    int row;
    int col;
    int footprint;

    public Node(int height, int row, int col, int footprint) {
        this.height = height;
        this.row = row;
        this.col = col;
        this.footprint = footprint;
    }
}