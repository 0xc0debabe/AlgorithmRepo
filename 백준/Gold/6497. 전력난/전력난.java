import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static boolean[] visited;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                graph.add(new ArrayList<>());
            }

            int totalCost = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                graph.get(x).add(new Edge(y, z));
                graph.get(y).add(new Edge(x, z));
                totalCost += z;
            }

            visited = new boolean[m];
            int mstCost = prim(0);
            System.out.println(totalCost - mstCost);
        }
    }

    static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int cost = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (visited[now.to]) continue;
            visited[now.to] = true;
            cost += now.weight;

            for (Edge next : graph.get(now.to)) {
                if (!visited[next.to]) {
                    pq.offer(new Edge(next.to, next.weight));
                }
            }
        }

        return cost;
    }
}