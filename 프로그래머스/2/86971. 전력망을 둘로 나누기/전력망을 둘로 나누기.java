import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        sol.solution(9, a);
    }

    List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        int answer = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int s = wire[0];
            int e = wire[1];
            boolean[] isVisited = new boolean[n + 1];

            list.get(s).remove(Integer.valueOf(e));
            list.get(e).remove(Integer.valueOf(s));

            int a = dfs(s, isVisited);
            int b = n - a;

            list.get(s).add(e);
            list.get(e).add(s);

            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    private int dfs(int start, boolean[] isVisited) {
        if (isVisited[start]) return 0;
        isVisited[start] = true;
        int sum = 1;
        for (int next : list.get(start)) {
            sum += dfs(next, isVisited);
        }

        return sum;
    }

}

