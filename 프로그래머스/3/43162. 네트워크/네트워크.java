
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        int[][] arr = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(s.solution(n, arr));
    }

    public int solution(int n, int[][] computers) {
        List<List<Network>> list = new ArrayList<>();
        for (int i = 0; i <= computers.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i <= computers.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || computers[i - 1][j - 1] == 0) continue;

                list.get(i).add(new Network(j));
                list.get(j).add(new Network(i));
            }
        }

        boolean[] isVisited = new boolean[n + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                dfs(i, list, isVisited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int vertex, List<List<Network>> list, boolean[] isVisited) {
        if (isVisited[vertex]) return;

        isVisited[vertex] = true;
        for (Network net : list.get(vertex)) {
            dfs(net.vertex, list, isVisited);
        }

    }

    static class Network{
        int vertex;

        public Network(int vertex) {
            this.vertex = vertex;
        }
    }

}