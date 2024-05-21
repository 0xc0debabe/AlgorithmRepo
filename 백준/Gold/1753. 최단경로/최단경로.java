import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] distance;
    static boolean[] isVisited;
    static List<Node>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        lists = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            lists[i] = new ArrayList<>();
        }
        isVisited = new boolean[V + 1];
        distance = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            lists[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(K, 0));
        distance[K] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (isVisited[now.to]) continue;
            isVisited[now.to] = true;

            for (Node next : lists[now.to]) {
                if (distance[next.to] > distance[now.to] + next.weight) {
                    distance[next.to] = distance[now.to] + next.weight;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (!isVisited[i]) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(distance[i]).append("\n");
        }

        System.out.println(sb);
    }
}

class Node {
    int to, weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

