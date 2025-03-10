import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{0, 1, 1}, {2, 3, 1}, {3, 1, 3}, {4, 0, 5}, {4, 2, 4}};
        System.out.println(solution.solution(5, arr));
    }

    List<List<int[]>> list = new ArrayList<>();
    public int solution(int n, int[][] costs) {
        for (int i = 0; i < n; i++) list.add(new ArrayList<>());

        int startVertex = 0;
        int min = Integer.MAX_VALUE;
        for (int[] cost : costs) {
            int from = cost[0];
            int to = cost[1];
            int weight = cost[2];

            list.get(from).add(new int[]{to, weight});
            list.get(to).add(new int[]{from, weight});

            if (weight < min) {
                min = weight;
                startVertex = from;
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{startVertex, 0});
        boolean[] isVisited = new boolean[n + 1];
        isVisited[startVertex] = true;
        int answer = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            answer += now[1];
            isVisited[now[0]] = true;

            for (int[] next : list.get(now[0])) {
                if (!isVisited[next[0]]) {
                    pq.add(new int[]{next[0], next[1]});
                }
            }
        }

        return answer;
    }


}