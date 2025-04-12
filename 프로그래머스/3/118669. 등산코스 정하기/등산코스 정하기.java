import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
        int[] gates = {1, 3};
        int[] summits = {5};
        solution.solution(6, arr, gates, summits);
    }


    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        Set<Integer> pathSet = new HashSet<>();
        for (int gate : gates) pathSet.add(gate);
        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) summitSet.add(summit);
        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int gate : gates) {
            dist[gate] = 0;
            pq.add(new Node(gate, 0));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (summitSet.contains(now.vertex)) continue;
            if (now.weight > dist[now.vertex]) continue;

            for (Node next : list.get(now.vertex)) {
                if (pathSet.contains(next.vertex)) continue;

                int newDist = Math.max(now.weight, next.weight);
                if (dist[next.vertex] > newDist) {
                    dist[next.vertex] = newDist;
                    pq.add(new Node(next.vertex, newDist));
                }
            }
        }

        int minSummit = 0, minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);

        for (int summit : summits) {
            if (dist[summit] < minIntensity) {
                minIntensity = dist[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}