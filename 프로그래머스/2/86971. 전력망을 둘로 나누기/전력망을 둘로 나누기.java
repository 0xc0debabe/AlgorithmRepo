
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 9;
        int[][] ar = {
                {1, 3},
                {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}
        };
        sol.solution(a, ar);
    }

    List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];

            list.get(s).remove(Integer.valueOf(e));
            list.get(e).remove(Integer.valueOf(s));

            boolean[] isVisited = new boolean[n + 1];
            int part = dfs(s, isVisited);
            int diff = Math.abs(n - part - part);
            answer = Math.min(answer, diff);

            list.get(s).add(e);
            list.get(e).add(s);
        }

        return answer;
    }

    int dfs(int start, boolean[] isVisited) {
        if (isVisited[start]) return 0;

        int sum = 1;
        isVisited[start] = true;
        for (int next : list.get(start)) {
            sum += dfs(next, isVisited);
        }

        return sum;
    }

}