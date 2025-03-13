class Solution {
    public static void main(String[] args) {
        int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        Solution solution = new Solution();
        solution.solution(5, result);
    }
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];

        for (int[] result : results) {
            int win = result[0];
            int lose = result[1];

            graph[win][lose] = 1;
            graph[lose][win] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    
                    if (graph[i][j] == 1 && graph[j][k] == 1) {
                        graph[i][k] = 1;
                        graph[k][i] = -1;
                    }

                    if (graph[i][j] == -1 && graph[j][k] == -1) {
                        graph[i][k] = -1;
                        graph[k][i] = 1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) {
                    cnt++;
                }
            }

            if (cnt == n - 1) answer++;
        }

        return answer;
    }
}