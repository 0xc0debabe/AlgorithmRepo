import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Node>> lists;
    static boolean[] isVisited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int vertex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists.get(start).add(new Node(vertex, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        pq.add(new Node(startDosi, 0));
        distance[startDosi] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int now_vertex = now.vertex;
            if (isVisited[now_vertex]) continue;
            isVisited[now_vertex] = true;

            for (Node next : lists.get(now_vertex)) {
                int next_vertex = next.vertex;
                int next_cost = next.cost;

                if (distance[next_vertex] > distance[now_vertex] + next_cost) {
                    distance[next_vertex] = distance[now_vertex] + next_cost;
                    pq.add(new Node(next_vertex, distance[next_vertex]));
                }
            }
        }

        System.out.println(distance[endDosi]);
    }
}

class Node {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

