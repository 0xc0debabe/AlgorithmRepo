import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<int[]>> fromGraph = new ArrayList<>();
    static List<List<int[]>> toGraph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            fromGraph.add(new ArrayList<>());
            toGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (from == x) {
                fromGraph.get(from).add(new int[]{to, cost});
            } else if (to == x) {
                toGraph.get(to).add(new int[]{from, cost});
            } else {
                fromGraph.get(from).add(new int[]{to, cost});
                toGraph.get(to).add(new int[]{from, cost});
            }
        }

        int[] fromDijkstra = dijkstra(n, x, fromGraph);
        int[] toDijkstra = dijkstra(n, x, toGraph);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (fromDijkstra[i] == Integer.MAX_VALUE || toDijkstra[i] == Integer.MAX_VALUE) continue;
            int sum = fromDijkstra[i] + toDijkstra[i];
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }

    private static int[] dijkstra(int n, int start, List<List<int[]>> graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowVertex = now[0];
            int nowCost = now[1];

            if (dist[nowVertex] < nowCost) continue;

            for (int[] next : graph.get(nowVertex)) {
                int nextVertex = next[0];
                int nextCost = next[1];

                if (dist[nextVertex] > dist[nowVertex] + nextCost) {
                    dist[nextVertex] = dist[nowVertex] + nextCost;
                    pq.add(new int[]{nextVertex, dist[nextVertex]});
                }
            }
        }

        return dist;
    }
}