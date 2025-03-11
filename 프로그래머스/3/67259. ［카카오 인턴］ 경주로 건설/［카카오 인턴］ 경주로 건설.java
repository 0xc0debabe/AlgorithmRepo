import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 1, 0, 0}
        };
        System.out.println(solution.solution(board));
    }


    public int solution(int[][] board) {
        int n = board.length;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][][] dist = new int[4][n][n];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dist[i][j][k] = 100_000_000;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            dist[i][0][0] = 0;
        }

        int answer = 0;
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.add(new Car(0, 0, 0, -1));
        while (!pq.isEmpty()) {
            Car now = pq.poll();
            int row = now.row;
            int col = now.col;
            int dir = now.dir;
            int weight = now.weight;

            if (row == n - 1 && col == n - 1) {
                answer = weight;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + row;
                int nc = dc[i] + col;

                if (nr < 0 || nc < 0 || nr >= n || nc >= n || board[nr][nc] == 1) continue;

                int newWeight = ((dir == i || dir == -1) ? 100 : 600) + weight;
//                if (dist[i][nr][nc] > dist[dir][row][col] + newWeight) {
//                    dist[i][nr][nc] = dist[dir][row][col] + newWeight;
//                    pq.add(new Car(nr, nc, dist[i][nr][nc], i));
//                }
                if (dist[i][nr][nc] > newWeight) {
                    dist[i][nr][nc] = newWeight;
                    pq.add(new Car(nr, nc, newWeight, i));
                }
            }
        }

        return answer;
    }

    static class Car implements Comparable<Car>{
        int row;
        int col;
        int weight;
        int dir;

        public Car(int row, int col, int weight, int dir) {
            this.row = row;
            this.col = col;
            this.weight = weight;
            this.dir = dir;
        }

        @Override
        public int compareTo(Car o) {
            return this.weight - o.weight;
        }
    }

}