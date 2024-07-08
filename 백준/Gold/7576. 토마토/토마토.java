import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[m][n];
        Queue<Node> queue = new LinkedList<>();
        int zeroCnt = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1){
                    queue.add(new Node(i, j, 0));
                } else if (board[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int tmp = 0;
        int answer = 0;
        if (zeroCnt == 0) {
            answer = 0;
        } else {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int row = node.row;
                int col = node.col;
                tmp = node.time;


                for (int i = 0; i < 4; i++) {
                    int nx = row + dx[i];
                    int ny = col + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                        if (board[nx][ny] == 0) {
                            queue.add(new Node(row + dx[i], col + dy[i], node.time + 1));
                            board[nx][ny] = -1;
                            zeroCnt--;
                        }
                    }
                }

            }
            if (zeroCnt != 0) {
                answer = -1;
            } else {
                answer = tmp;
            }
        }

        System.out.println(answer);
    }
}

class Node {
    int row;
    int col;
    int time;

    public Node(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}