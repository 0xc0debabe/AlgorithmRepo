import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        int sr = 0;
        int sc = 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'J') {
                    sr = i;
                    sc = j;
                } else if (board[i][j] == 'F') {
                    queue.add(new Node(i, j, true, -1));
                    isVisited[1][i][j] = true;
                }
            }
        }

        isVisited[0][sr][sc] = true;
        String answer = "IMPOSSIBLE";
        queue.add(new Node(sr, sc, false, 0));


        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            boolean flag = false;


            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (now.isFire) {
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || isVisited[1][nr][nc] || board[nr][nc] == '#') continue;
                    isVisited[1][nr][nc] = true;
                    board[nr][nc] = 'F';
                    queue.add(new Node(nr, nc, true, -1));
                } else {
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        answer = String.valueOf(now.count + 1);
                        flag = true;
                        break;
                    }

                    if (isVisited[0][nr][nc] || board[nr][nc] != '.') continue;
                    isVisited[0][nr][nc] = true;
                    board[nr][nc] = 'J';
                    queue.add(new Node(nr, nc, false, now.count + 1));
                }
            }
            if (flag) break;
        }

        System.out.println(answer);
    }

    static class Node {
        int r, c;
        boolean isFire;
        int count;

        public Node(int r, int c, boolean isFire, int count) {
            this.r = r;
            this.c = c;
            this.isFire = isFire;
            this.count = count;
        }
    }

}