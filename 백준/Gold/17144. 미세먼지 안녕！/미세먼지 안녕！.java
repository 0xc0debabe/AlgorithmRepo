import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] board;
    static int n, m;
    static Queue<Node> queue = new LinkedList<>();
 //    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        int cleanerX1 = -1;
        int cleanerY1 = -1;

        int cleanerX2 = -1;
        int cleanerY2 = -1;


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == -1) {
                    if (cleanerX1 == -1) {
                        cleanerX1 = i;
                        cleanerY1 = j;
                    } else {
                        cleanerX2 = i;
                        cleanerY2 = j;
                    }
                }
            }
        }

        while (t-- > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] >= 5) {
                        dust1(i, j);
                    }
                }
            }
            dust2();
            clean1(cleanerX1, cleanerY1 + 1);
            board[cleanerX1][cleanerY1 + 1] = 0;
            clean2(cleanerX2, cleanerY2 + 1);
            board[cleanerX2][cleanerY2 + 1] = 0;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += board[i][j];
            }
        }
        System.out.println(answer + 2);
    }

    static void dust1(int row, int col) {
        int tmp = board[row][col] / 5;
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] != -1) {
                queue.add(new Node(nx, ny, tmp));
                cnt++;
            }
        }

        board[row][col] -= tmp * cnt;
    }

    static void dust2() {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int row1 = poll.row;
            int col1 = poll.col;
            int tmp1 = poll.tmp;

            board[row1][col1] += tmp1;
        }
    }

    static void clean1(int row, int col) {
        if (col == 0) {

            if (board[row + 1][col] != -1) {
                clean1(row + 1, col);
                board[row + 1][col] = board[row][col];
                return;
            }
            return;
        }

        if (row == 0) {
            clean1(row, col - 1);
            board[row][col - 1] = board[row][col];
            return;
        }

        if (col == m - 1) {
            clean1(row - 1, col);
            board[row - 1][col] = board[row][col];
            return;
        }

        clean1(row, col + 1);
        board[row][col + 1] = board[row][col];
    }

    static void clean2(int row, int col) {
        if (col == 0) {

            if (board[row - 1][col] != -1){
                clean2(row - 1, col);
                board[row - 1][col] = board[row][col];
                return;
            }
            return;
        }

        if (row == n - 1) {
            clean2(row, col - 1);
            board[row][col - 1] = board[row][col];
            return;
        }

        if (col == m - 1) {
            clean2(row + 1, col);
            board[row + 1][col] = board[row][col];
            return;
        }

        clean2(row, col + 1);
        board[row][col + 1] = board[row][col];
    }
}

class Node {
    int row;
    int col;
    int tmp;

    public Node(int row, int col, int tmp) {
        this.row = row;
        this.col = col;
        this.tmp = tmp;
    }
}