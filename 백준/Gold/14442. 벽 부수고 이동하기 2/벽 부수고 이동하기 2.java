import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        isVisited = new boolean[K + 1][N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = s.charAt(j);
                board[i][j] = c - '0';
            }
        }

        int answer = -1;
        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0, 0, 0, 1));
        isVisited[0][0][0] = true;

        while(!q.isEmpty()) {
            Move now = q.poll();

            if(now.r == N - 1 && now.c == M - 1) {
                answer = now.moveCnt;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nr = dr[i] + now.r;
                int nc = dc[i] + now.c;

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                int bCnt = now.breakCnt;
                if(board[nr][nc] == 1) {
                    if(now.breakCnt >= K) continue;
                    bCnt++;
                }
                
                if(isVisited[bCnt][nr][nc]) continue;
                isVisited[bCnt][nr][nc] = true;
                q.add(new Move(nr, nc, bCnt, now.moveCnt + 1));
            }

        }

        System.out.println(answer);
    }

    static class Move {
        int r;
        int c;
        int breakCnt;
        int moveCnt;

        public Move(int r, int c, int count, int moveCnt) {
            this.r = r;
            this.c = c;
            this.breakCnt = count;
            this.moveCnt = moveCnt;
        }
    }
}