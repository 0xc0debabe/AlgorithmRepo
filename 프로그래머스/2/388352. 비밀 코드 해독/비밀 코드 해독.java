import java.util.*;

class Solution {

    boolean[] isVisited;
    int answer = 0;

    public int solution(int n, int[][] q, int[] ans) {
        isVisited = new boolean[n + 1];
        dfs(1, n, q, ans, 0, new ArrayList<>());
        return answer;
    }

    private void dfs(int idx, int n, int[][] q, int[] ans, int depth, List<Integer> selected) {
        if (depth == 5) {  // ✅ 종료 조건을 5개로 수정
            if (isValid(selected, q, ans)) {
                answer++;
            }
            return;
        }

        for (int i = idx; i <= n; i++) {
            selected.add(i);
            dfs(i + 1, n, q, ans, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    private boolean isValid(List<Integer> secretCode, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;
            for (int num : q[i]) {
                if (secretCode.contains(num)) matchCount++;
            }
            if (matchCount != ans[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] q = {
            {2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, 
            {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}
        };
        int[] ans = {2, 1, 3, 0, 1};
        System.out.println(solution.solution(15, q, ans)); // Expected output: 5
    }
}