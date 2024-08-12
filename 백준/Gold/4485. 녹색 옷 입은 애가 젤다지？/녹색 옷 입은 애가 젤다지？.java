import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            n = Integer.parseInt(s);
            arr = new int[n][n];
            isVisited = new boolean[n][n];
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dijkstra();
            sb.append("Problem ").append(idx++).append(": ").append(dist[n - 1][n - 1]).append("\n");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.value - y.value);
        pq.add(new Node(0, 0, arr[0][0]));
        dist[0][0] = arr[0][0];
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.row == n - 1 && now.col == n - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (dist[nx][ny] > now.value + arr[nx][ny]) {
                        dist[nx][ny] = now.value + arr[nx][ny];
                        pq.add(new Node(nx, ny, now.value + arr[nx][ny]));
                    }
                }
            }
        }
    }
}

class Node {
    int row;
    int col;
    int value;

    public Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
