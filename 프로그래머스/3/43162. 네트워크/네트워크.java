import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    boolean[] isVisited;
    List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        isVisited = new boolean[n ];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j) continue;

                if (computers[i][j] == 1) list.get(i).add(j);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int start) {
        isVisited[start] = true;
        for (int next : list.get(start)) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }

}