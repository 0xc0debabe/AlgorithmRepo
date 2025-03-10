import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        solution.solution(6, arr);
    }


    public int solution(int n, int[][] edge) {
        List<List<Integer>> list = new ArrayList<>();
        int[] dist = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int[] ints : edge) {
            int from = ints[0];
            int to = ints[1];

            list.get(from).add(to);
            list.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        int max = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    dist[next] = dist[now] + 1;
                    max = Math.max(max, dist[next]);
                    queue.add(next);
                }

            }
        }

        int answer = 0;
        for (int v : dist) if (max == v) answer++;
        return answer;
    }


}