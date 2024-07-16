import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] board;
    static Queue<Node> dirQueue = new LinkedList<>();
    static int n, nowTime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int snakeDir = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nowTime = 0;
        board = new int[n + 1][n + 1];
        int appleNum = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < appleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int appleRow = Integer.parseInt(st.nextToken());
            int appleCol = Integer.parseInt(st.nextToken());
            board[appleRow][appleCol] = 2;
        }
        int moveDirNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < moveDirNum; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            dirQueue.add(new Node(time, dir));
        }
        board[1][1] = 1;
        bfs();
        System.out.println(nowTime + 1);
    }

    static void bfs() {
        Queue<pos> queue = new LinkedList<>();
        Queue<Integer> snakeDirQueue = new LinkedList<>();
        queue.add(new pos(1, 1));
        int tailRow = 1;
        int tailCol = 1;
        while (!queue.isEmpty()) {
            pos poll = queue.poll();
            int nowHeadRow = poll.row;
            int nowHeadCol = poll.col;

            if (!dirQueue.isEmpty()) {
                if (dirQueue.peek().time == nowTime) {
                    Node poll1 = dirQueue.poll();
                    String dir = poll1.dir;

                    if (dir.equals("L")) {
                        snakeDir = (snakeDir + 3) % 4;
                    } else {
                        snakeDir = (snakeDir + 1) % 4;
                    }
                }
            }
            snakeDirQueue.add(snakeDir);

            int nextHeadRow = nowHeadRow + dx[snakeDir];
            int nextHeadCol = nowHeadCol + dy[snakeDir];

            if (nextHeadRow > 0 && nextHeadCol > 0 && nextHeadRow <= n && nextHeadCol <= n) {
                if (board[nextHeadRow][nextHeadCol] != 1) { // 자기몸에 안부딫혔을경우
                    if (board[nextHeadRow][nextHeadCol] != 2) { // 앞에 사과가 없을경우
                        board[tailRow][tailCol] = 0;
                        board[nextHeadRow][nextHeadCol] = 1;
                        int sna = snakeDirQueue.poll();
                        tailRow = tailRow + dx[sna];
                        tailCol = tailCol + dy[sna];
                    } else if (board[nextHeadRow][nextHeadCol] == 2) { // 사과먹음
                        board[nextHeadRow][nextHeadCol] = 1;
                    }
                    queue.add(new pos(nextHeadRow, nextHeadCol));
                    nowTime++;
                }
            }
        }
    }
}

class pos {
    int row;
    int col;

    public pos(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Node {
    int time;
    String dir;

    public Node(int time, String dir) {
        this.time = time;
        this.dir = dir;
    }
}