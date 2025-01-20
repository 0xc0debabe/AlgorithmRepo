import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] maps1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        String[] maps2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println(sol.solution(maps1)); // Expected output: 16
        System.out.println(sol.solution(maps2)); // Expected output: -1
    }

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] board = new char[n][m];
        int startX = 0, startY = 0, endX = 0, endY = 0;

        // 미로 배열과 출발, 도착점 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = maps[i].charAt(j);
                if (board[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (board[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        // BFS 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][][] visited = new boolean[2][n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0, false));
        visited[0][startX][startY] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 레버를 당긴 상태에서 출구에 도달하면 종료
            if (now.x == endX && now.y == endY && now.leverPulled) {
                return now.distance;
            }

            // 4방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 범위를 벗어나거나 벽인 경우 스킵
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 'X') {
                    continue;
                }

                // 레버를 당긴 상태 관리
                boolean leverPulled = now.leverPulled || (board[nx][ny] == 'L');

                // 해당 상태로 방문한 적이 없으면 이동
                int leverState = leverPulled ? 1 : 0;
                if (!visited[leverState][nx][ny]) {
                    visited[leverState][nx][ny] = true;
                    queue.add(new Node(nx, ny, now.distance + 1, leverPulled));
                }
            }
        }

        return -1; // 탈출 불가능한 경우
    }

    // BFS에서 사용할 노드 클래스
    static class Node {
        int x, y, distance;
        boolean leverPulled;

        public Node(int x, int y, int distance, boolean leverPulled) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.leverPulled = leverPulled;
        }
    }
}