import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(15, 50, 5));
    }

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        boolean[] isVisited = new boolean[1_000_001];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == y) return now[1];

            if (now[0] > 1_000_000 || isVisited[now[0]] || now[0] > y) continue;

            isVisited[now[0]] = true;
            queue.add(new int[]{now[0] * 2, now[1] + 1});
            queue.add(new int[]{now[0] * 3, now[1] + 1});
            queue.add(new int[]{now[0] + n, now[1] + 1});
        }

        return -1;
    }

}