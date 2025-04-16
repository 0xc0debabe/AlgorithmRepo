import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        Queue<Robot> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        Robot start = new Robot(0, 0, 0, 1, 0);
        q.add(start);
        visited.add(start.getKey());

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            Robot now = q.poll();
            int r1 = now.r1, c1 = now.c1;
            int r2 = now.r2, c2 = now.c2;

            if ((r1 == n - 1 && c1 == n - 1) || (r2 == n - 1 && c2 == n - 1)) {
                return now.time;
            }

            // 이동
            for (int[] d : dirs) {
                int nr1 = r1 + d[0], nc1 = c1 + d[1];
                int nr2 = r2 + d[0], nc2 = c2 + d[1];

                if (isValid(nr1, nc1, board) && isValid(nr2, nc2, board)) {
                    Robot next = new Robot(nr1, nc1, nr2, nc2, now.time + 1);
                    if (!visited.contains(next.getKey())) {
                        visited.add(next.getKey());
                        q.add(next);
                    }
                }
            }

            // 회전
            if (r1 == r2) { // 가로
                for (int d : new int[]{-1, 1}) {
                    if (isValid(r1 + d, c1, board) && isValid(r2 + d, c2, board)) {
                        Robot r1pivot = new Robot(r1, c1, r1 + d, c1, now.time + 1);
                        Robot r2pivot = new Robot(r2, c2, r2 + d, c2, now.time + 1);
                        if (!visited.contains(r1pivot.getKey())) {
                            visited.add(r1pivot.getKey());
                            q.add(r1pivot);
                        }
                        if (!visited.contains(r2pivot.getKey())) {
                            visited.add(r2pivot.getKey());
                            q.add(r2pivot);
                        }
                    }
                }
            } else { // 세로
                for (int d : new int[]{-1, 1}) {
                    if (isValid(r1, c1 + d, board) && isValid(r2, c2 + d, board)) {
                        Robot c1pivot = new Robot(r1, c1, r1, c1 + d, now.time + 1);
                        Robot c2pivot = new Robot(r2, c2, r2, c2 + d, now.time + 1);
                        if (!visited.contains(c1pivot.getKey())) {
                            visited.add(c1pivot.getKey());
                            q.add(c1pivot);
                        }
                        if (!visited.contains(c2pivot.getKey())) {
                            visited.add(c2pivot.getKey());
                            q.add(c2pivot);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private boolean isValid(int r, int c, int[][] board) {
        return r >= 0 && c >= 0 && r < board.length && c < board.length && board[r][c] == 0;
    }

    static class Robot {
        int r1, c1, r2, c2, time;

        public Robot(int r1, int c1, int r2, int c2, int time) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.time = time;
        }

        public String getKey() {
            if (r1 < r2 || (r1 == r2 && c1 < c2))
                return r1 + "," + c1 + "," + r2 + "," + c2;
            else
                return r2 + "," + c2 + "," + r1 + "," + c1;
        }
    }
}