import java.io.*;
import java.util.*;

class Main {
    static int K, N, M;
    static int[][] board;
    static int[] dr = {-1 ,1 ,0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static int[] hdr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] isVisited = new boolean[K + 1][N][M];
        isVisited[0][0][0] = true;
        q.add(new int[]{0, 0, 0, 0});
        int totalMoveCnt = -1;

        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int nowRow = poll[0];
            int nowCol = poll[1];
            int horseMoveCnt = poll[2];
            int nowTotalMoveCnt = poll[3];

            if(nowRow == N - 1 && nowCol == M - 1) {
                totalMoveCnt = nowTotalMoveCnt;
                break;
            }

            for(int d = 0; d < 4; d++) {
                int nr = dr[d] + nowRow;
                int nc = dc[d] + nowCol;

                if(inSpace(nr, nc) && !isBlock(nr, nc) && !isVisited[horseMoveCnt][nr][nc]) {
                    isVisited[horseMoveCnt][nr][nc] = true;
                    q.add(new int[]{nr, nc, horseMoveCnt, nowTotalMoveCnt + 1});
                }
            }

            if(horseMoveCnt >= K) continue;
            int newHorseMoveCnt = horseMoveCnt + 1;
            for(int d = 0; d < 8; d++) {
                int nr = hdr[d] + nowRow;
                int nc = hdc[d] + nowCol;

                if(inSpace(nr, nc) && !isBlock(nr, nc) && !isVisited[newHorseMoveCnt][nr][nc]) {
                    isVisited[newHorseMoveCnt][nr][nc] = true;
                    q.add(new int[]{nr, nc, newHorseMoveCnt, nowTotalMoveCnt + 1});
                }
            }
        }

        return totalMoveCnt;
    }

    static boolean inSpace(int row, int col) {
        if(row < 0 || col < 0 || row >= N || col >= M) return false;
        return true;
    }

    static boolean isBlock(int row, int col) {
        if(board[row][col] == 1) return true;
        return false;
    }

}