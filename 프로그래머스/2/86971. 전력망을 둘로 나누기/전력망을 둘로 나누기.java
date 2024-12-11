
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
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        // 모든 간선을 끊어보며 최소 차이 계산
        for (int[] wire : wires) {
            // 간선 끊기
            list.get(wire[0]).remove((Integer) wire[1]);
            list.get(wire[1]).remove((Integer) wire[0]);

            // 한 쪽 서브트리 크기 계산
            boolean[] isVisited = new boolean[n + 1];
            int subtreeSize = dfs(1, isVisited);

            // 두 서브트리 크기 차이 계산
            int diff = Math.abs(subtreeSize - (n - subtreeSize));
            answer = Math.min(answer, diff);

            // 간선 복구
            list.get(wire[0]).add(wire[1]);
            list.get(wire[1]).add(wire[0]);
        }

        return answer;
    }

    int dfs(int node, boolean[] isVisited) {
        isVisited[node] = true;
        int size = 1;

        for (int neighbor : list.get(node)) {
            if (!isVisited[neighbor]) {
                size += dfs(neighbor, isVisited);
            }
        }

        return size;
    }
}