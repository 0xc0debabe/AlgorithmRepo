import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    List<List<Node>> list = new ArrayList<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int weight = fare[2];

            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }

        int[] fromStart = dijkstra(s, n);
        int[] fromA = dijkstra(a, n);
        int[] fromB = dijkstra(b, n);
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, fromA[i] + fromB[i] + fromStart[i]);
        return answer;
    }

    private int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : list.get(now.vertex)) {
                if (dist[next.vertex] > dist[now.vertex] + next.weight) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

}