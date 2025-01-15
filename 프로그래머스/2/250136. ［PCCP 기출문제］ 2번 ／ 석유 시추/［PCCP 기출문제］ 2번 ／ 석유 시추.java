import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] situ = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        System.out.println(solution.solution(situ));
    }

    Map<Integer, Integer> situLocation = new HashMap<>();
    int situIdx = 1;
    public int solution(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        int[][] situ = new int[n][m];
        for (int i = 0; i < situ.length; i++) Arrays.fill(situ[i], -1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (situ[i][j] == -1 && land[i][j] == 1) {
                    int situSize = searchArea(situ, land, n, m, i, j);
                    situLocation.put(situIdx++, situSize);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (situ[j][i] > 0){
                    set.add(situ[j][i]);
                }
            }

            int max = 0;
            for (int v : set) {
                max += situLocation.get(v);
            }
            answer = Math.max(answer, max);
        }

        return answer;
    }

    private int searchArea(int[][] situ, int[][] land, int n, int m, int row, int col) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        int cnt = 1;
        land[row][col] = 0;
        situ[row][col] = situIdx;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && land[nr][nc] == 1) {
                    land[nr][nc] = 0;
                    situ[nr][nc] = situIdx;
                    cnt++;
                    queue.add(new int[]{nr, nc});
                }
            }        
            
        }

        return cnt;
    }


}