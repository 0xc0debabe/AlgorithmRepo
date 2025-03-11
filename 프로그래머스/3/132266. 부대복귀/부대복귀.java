import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] roads = {{1, 2}, {2, 3}};
        int[] sources = {2,3};
        int[] solution1 = solution.solution(3, roads, sources, 1);
        for (int i : solution1) {
            System.out.println(i);
        }
    }

    List<List<Integer>> list = new ArrayList<>();
    int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        dist = new int[n + 1];
        for (int i = 0; i < roads.length; i++) {
            int from = roads[i][0];
            int to = roads[i][1];

            list.get(from).add(to);
            list.get(to).add(from);
        }

        int[] answer = new int[sources.length];
        dijkstra(destination);

        int idx = 0;
        for (int source : sources) {
            answer[idx++] = dist[source] == Integer.MAX_VALUE ? -1 : dist[source];
        }

        return answer;
    }

    private void dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();


            for (int next : list.get(now[0])) {
                if (dist[next] > dist[now[0]] + 1) {
                    dist[next] = dist[now[0]] + 1;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }
    }

}