import java.util.*;

class Solution {
    private static final int SCALE = 2; // 좌표 배율 증가
    private static final int MAX_COORD = 50 * SCALE;
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[MAX_COORD + 1][MAX_COORD + 1];

        // 1. 좌표 확장 및 테두리와 내부 설정
        for (int[] rect : rectangle) {
            int x1 = rect[0] * SCALE, y1 = rect[1] * SCALE;
            int x2 = rect[2] * SCALE, y2 = rect[3] * SCALE;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (board[x][y] != 2) board[x][y] = 1; // 테두리
                    } else {
                        board[x][y] = 2; // 내부
                    }
                }
            }
        }

        // 2. BFS로 최단 거리 탐색
        return bfs(board, characterX * SCALE, characterY * SCALE, itemX * SCALE, itemY * SCALE);
    }

    private int bfs(int[][] board, int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[MAX_COORD + 1][MAX_COORD + 1];

        queue.add(new int[]{startX, startY, 0}); // {x, y, 거리}
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == targetX && y == targetY) {
                return distance / SCALE; // 원래 크기로 복원
            }

            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx <= MAX_COORD && ny <= MAX_COORD) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }

    // 테스트 케이스 실행
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
            new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8)); // 17
        System.out.println(solution.solution(
            new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1)); // 11
        System.out.println(solution.solution(
            new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7)); // 9
        System.out.println(solution.solution(
            new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10)); // 15
        System.out.println(solution.solution(
            new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3)); // 10
    }
}