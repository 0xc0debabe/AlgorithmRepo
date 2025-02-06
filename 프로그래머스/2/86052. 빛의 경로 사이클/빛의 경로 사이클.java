import java.util.*;

class Solution {
    static int R, C;
    static boolean[][][] isVisited;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1}; 

    public int[] solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        isVisited = new boolean[R][C][4]; // 3차원 방문 체크

        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[i][j][d]) {
                        answer.add(findCycle(grid, i, j, d));
                    }
                }
            }
        }
        
        Collections.sort(answer); // 오름차순 정렬
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static int findCycle(String[] grid, int r, int c, int d) {
        int cnt = 0; // 사이클 길이 카운트

        while (!isVisited[r][c][d]) {
            isVisited[r][c][d] = true; // 방문 처리
            cnt++;

            // 현재 위치의 문자에 따라 방향 변경
            if (grid[r].charAt(c) == 'L') {
                d = (d + 3) % 4; // 좌회전
            } else if (grid[r].charAt(c) == 'R') {
                d = (d + 1) % 4; // 우회전
            }

            // 다음 위치 계산 (격자를 벗어나면 반대편으로 이동)
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }

        return cnt;
    }
}