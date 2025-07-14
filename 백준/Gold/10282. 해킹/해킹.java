import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int comNum = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int hackedCom = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();

            for (int j = 0; j <= comNum; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int seconds = Integer.parseInt(st.nextToken());

                graph.get(from).add(new int[]{to, seconds});
            }

            int[] dijkstra = dijkstra(hackedCom, comNum);
            sb.append(dijkstra[0]).append(" ").append(dijkstra[1]).append("\n");
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int hackedCom, int comNum) {
        int[] dist = new int[comNum + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[hackedCom] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{hackedCom, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowVertex = now[0];
            int nowSeconds = now[1];

            for (int[] next : graph.get(nowVertex)) {
                int nextVertex = next[0];
                int nextSeconds = next[1];
                if (dist[nextVertex] > nowSeconds + nextSeconds) {
                    dist[nextVertex] = nowSeconds + nextSeconds;
                    pq.add(new int[]{nextVertex, dist[nextVertex]});
                }
            }
        }

        int count = 0;
        int max = 0;
        for (int i = 1; i <= comNum; i++) {
            if (Integer.MAX_VALUE == dist[i]) continue;

            max = Math.max(max, dist[i]);
            count++;
        }

        return new int[]{count, max};
    }

}