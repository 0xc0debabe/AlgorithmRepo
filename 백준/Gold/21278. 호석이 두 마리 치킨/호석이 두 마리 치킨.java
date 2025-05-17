import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int l1 = -1;
        int l2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int[] dist = new int[n + 1];
                Arrays.fill(dist, Integer.MAX_VALUE);
                dijkstra(i, dist);
                dijkstra(j, dist);

                int sum = 0;
                for (int d : dist) {
                    if (d != Integer.MAX_VALUE) sum += d * 2;
                }

                if (min > sum) {
                    l1 = i;
                    l2 = j;
                    min = sum;
                }
            }

        }

        System.out.println(l1 + " " + l2 + " " + min);
    }

    static void dijkstra(int start, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            for (int next : list.get(now[0])) {
                if (dist[next] > now[1] + 1) {
                    pq.add(new int[]{next, now[1] + 1});
                    dist[next] = now[1] + 1;
                }
            }
        }

    }

}
