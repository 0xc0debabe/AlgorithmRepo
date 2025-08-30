import java.io.*;
import java.util.*;

class Main {
    static char[][] board;
    static boolean[][] selected;
    static int N = 5;
    static int answer = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[N][N];
        selected = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < N; j++) {
                char c = s.charAt(j);
                board[i][j] = c;
            }
        }
        int[] comb = new int[7];
        combination(comb, 0, 0);

        System.out.println(answer);
    }

    static void combination(int[] comb, int idx, int depth) {
        if(depth == 7) {
            if(isConnected(comb)) answer++;
            return;
        }

        for(int i = idx; i < N * N; i++) {
            int row = i / N;
            int col = i % N;

            comb[depth] = i;
            selected[row][col] = true;
            combination(comb, i + 1, depth + 1);
            selected[row][col] = false;
        }

    }

    static boolean isConnected(int[] comb) {
        int sr = comb[0] / N;
        int sc = comb[0] % N;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        q.add(new int[]{sr, sc});
        isVisited[sr][sc] = true;

        int cnt = 0;
        int sCnt = 0;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int row = poll[0];
            int col = poll[1];
            cnt++;
            if (board[row][col] == 'S') sCnt++;

            for(int i = 0; i < 4; i++) {
                int nr = dr[i] + row;
                int nc = dc[i] + col;

                if(inSpace(nr, nc) && selected[nr][nc] && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return cnt == 7 && sCnt >= 4;
    }

    static boolean inSpace(int row, int col) {
        if(row < 0 || col < 0 || row >= N || col >= N) return false;

        return true;
    }

}