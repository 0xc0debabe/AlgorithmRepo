import java.util.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            answer[i] = checkRoom(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean checkRoom(String[] room) {
        List<int[]> people = new ArrayList<>();

        // 1. 모든 P(응시자) 위치 찾기
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (room[r].charAt(c) == 'P') {
                    people.add(new int[]{r, c});
                }
            }
        }

        // 2. 각 P마다 BFS 탐색
        for (int[] start : people) {
            if (!bfs(start[0], start[1], room)) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int sr, int sc, String[] room) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.add(new int[]{sr, sc, 0}); // {행, 열, 이동거리}
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (dist >= 2) continue; // 거리 2 초과하면 검사 불필요

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) continue;

                visited[nr][nc] = true;

                if (room[nr].charAt(nc) == 'P') return false; // 거리 2 이내에 P가 있으면 실패
                if (room[nr].charAt(nc) == 'O') queue.add(new int[]{nr, nc, dist + 1}); // 빈 테이블이면 계속 탐색
            }
        }

        return true;
    }
}