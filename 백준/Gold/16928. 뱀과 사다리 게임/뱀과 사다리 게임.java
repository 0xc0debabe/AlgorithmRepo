import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] board = new int[101];
    static int[] dist = new int[101];
    static int[] move = {1, 2, 3, 4, 5, 6};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }
        Arrays.fill(dist, 100);
        dist[1] = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        bfs();
        System.out.println(dist[100]);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int nowPos = poll.nowPos;

            if (nowPos == 100) {
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nextPos = nowPos + move[i];

                if (nextPos <= 100 && dist[nextPos] == 100) {
                    dist[nextPos] = dist[nowPos] + 1;
                    if (board[nextPos] != 0) {

                        if (dist[board[nextPos]] > dist[nextPos]) {
                            dist[board[nextPos]] = dist[nextPos];
                        }

                        queue.add(new Node(board[nextPos]));
                    } else {
                        queue.add(new Node(nextPos));
                    }
                }
            }



        }
    }

}

class Node {
    int nowPos;

    public Node(int nowPos) {
        this.nowPos = nowPos;
    }
}