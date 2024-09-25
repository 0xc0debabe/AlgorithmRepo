import java.io.*;
import java.util.*;

public class Main {
    static int L, R, C; // 층, 행, 열
    static char[][][] building; // 빌딩 정보
    static boolean[][][] visited; // 방문 여부
    static int[] dl = {-1, 1, 0, 0, 0, 0}; // 상, 하, 좌, 우, 앞, 뒤
    static int[] dx = {0, 0, -1, 1, 0, 0}; 
    static int[] dy = {0, 0, 0, 0, -1, 1}; 
    static Queue<Node> queue; // BFS 탐색용 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break; // 입력 종료 조건

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            queue = new LinkedList<>();
            Node start = null;

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = line.charAt(c);
                        if (building[l][r][c] == 'S') {
                            start = new Node(l, r, c, 0); // 시작점 기록
                        }
                    }
                }
                br.readLine(); // 층과 층 사이의 빈 줄
            }

            int result = bfs(start); // BFS로 탈출 경로 탐색
            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }

        System.out.println(sb);
    }

    // BFS 탐색 함수
    static int bfs(Node start) {
        queue.add(start);
        visited[start.l][start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 탈출구 도착 시
            if (building[current.l][current.r][current.c] == 'E') {
                return current.time;
            }

            // 6방향 탐색 (상, 하, 좌, 우, 앞, 뒤)
            for (int i = 0; i < 6; i++) {
                int nl = current.l + dl[i];
                int nr = current.r + dx[i];
                int nc = current.c + dy[i];

                // 범위 밖이면 스킵
                if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C) continue;

                // 방문한 적 없고, 갈 수 있는 곳이면 이동
                if (!visited[nl][nr][nc] && building[nl][nr][nc] != '#') {
                    visited[nl][nr][nc] = true;
                    queue.add(new Node(nl, nr, nc, current.time + 1));
                }
            }
        }

        return -1; // 탈출구에 도착하지 못한 경우
    }

    // 노드 클래스 (현재 위치와 시간 정보 포함)
    static class Node {
        int l, r, c, time;

        public Node(int l, int r, int c, int time) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}