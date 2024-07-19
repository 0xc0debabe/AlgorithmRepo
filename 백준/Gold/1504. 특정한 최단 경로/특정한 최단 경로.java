import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    static boolean[] isVisited;
    static int v1, v2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
            list.get(e).add(new Node(s, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        long answer1 = 0;
        long answer2 = 0;
        int tmp = 0x7F7F7F7F;

        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(1);

        answer1 += dist[v2];
        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(v2);

        answer1 += dist[v1];
        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(v1);
        answer1 += dist[n];


        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(1);

        answer2 += dist[v1];
        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(v1);

        answer2 += dist[v2];
        isVisited = new boolean[n + 1];
        Arrays.fill(dist, tmp);
        dijkstra(v2);
        answer2 += dist[n];

        long answer = Math.min(answer1, answer2);

        if (answer >= tmp) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.coast));
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!isVisited[now.vertex]) {
                isVisited[now.vertex] = true;

                for (Node next : list.get(now.vertex)) {

                    if (dist[next.vertex] > dist[now.vertex] + next.coast) {
                        dist[next.vertex] = dist[now.vertex] + next.coast;
                        pq.add(new Node(next.vertex, dist[next.vertex]));
                    }
                }

            }

        }
    }

}

class Node {
    int vertex;
    int coast;

    public Node(int vertex, int coast) {
        this.vertex = vertex;
        this.coast = coast;
    }
}