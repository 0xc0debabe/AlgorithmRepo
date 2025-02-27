import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        System.out.println(solution.solution(5, arr, 3));
    }

    List<List<Node>> list = new ArrayList<>();
    int[] dist;
    public int solution(int N, int[][] road, int K) {
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; dist[1] = 0;
        for (int[] r : road) {
            int s = r[0];
            int e = r[1];
            int w = r[2];

            list.get(s).add(new Node(e, w));
            list.get(e).add(new Node(s, w));
        }

        bfs(K);
        int answer = 0;
        for (int i = 1; i < dist.length; i++) {
            int d = dist[i];
            if (d != Integer.MAX_VALUE) {
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int K) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();


            for (Node next : list.get(now.vertex)) {
                if (dist[next.vertex] > dist[now.vertex] + next.weight
                        && dist[now.vertex] + next.weight <= K) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    queue.add(new Node(next.vertex, dist[now.vertex] + next.weight));
                }
            }
        }
    }

    static class Node{
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}



