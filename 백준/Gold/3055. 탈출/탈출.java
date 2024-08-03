import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m;
    static char[][] board;
    static int[][] moveCnt;
    static boolean[][][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Node> waterList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startGosmRow = 0;
        int startGosmCol = 0;
        int startWaterRow = 0;
        int startWaterCol = 0;
        int endRow = 0;
        int endCol = 0;
        board = new char[n][m];
        moveCnt = new int[n][m];
        isVisited = new boolean[2][n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'S') {
                    startGosmRow = i;
                    startGosmCol = j;
                } else if (board[i][j] == '*') {
                    startWaterRow = i;
                    startWaterCol = j;
                    waterList.add(new Node(startWaterRow, startWaterCol, "water"));
                } else if (board[i][j] == 'D') {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        bfs(startGosmRow, startGosmCol);
        if (moveCnt[endRow][endCol] == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(moveCnt[endRow][endCol]);
        }
    }

    static void bfs(int startGosmRow, int startGosmCol) {
        Queue<Node> queue = new LinkedList<>();
        for (Node node : waterList) {
            int startWaterRow = node.row;
            int startWaterCol = node.col;
            queue.add(new Node(startWaterRow, startWaterCol, "water"));
            isVisited[0][startWaterRow][startWaterCol] = true;
        }
        queue.add(new Node(startGosmRow, startGosmCol, "gosm"));
        isVisited[1][startGosmRow][startGosmCol] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            if (board[poll.row][poll.col] == 'D') {
                break;
            }

            if (poll.type.equals("water")) {

                for (int i = 0; i < 4; i++) {
                    int nx = poll.row + dx[i];
                    int ny = poll.col + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] != 'X' && board[nx][ny] != 'D') {
                        if (!isVisited[0][nx][ny]) {
                            isVisited[0][nx][ny] = true;
                            board[nx][ny] = '*';
                            queue.add(new Node(nx, ny, "water"));
                        }
                    }

                }

            } else {

                for (int i = 0; i < 4; i++) {
                    int nx = poll.row + dx[i];
                    int ny = poll.col + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] != 'X' && board[nx][ny] != '*') {
                        if (!isVisited[1][nx][ny]) {
                            isVisited[1][nx][ny] = true;
                            board[nx][ny] = 'S';
                            moveCnt[nx][ny] = moveCnt[poll.row][poll.col] + 1;
                            queue.add(new Node(nx, ny, "gosm"));
                        }
                    }

                }

            }

        }
    }

}

class Node {
    int row;
    int col;
    String type;

    public Node(int row, int col, String type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }
}