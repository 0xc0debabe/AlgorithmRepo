import java.io.*;
import java.util.*;

class Main {

    static int N, L;
    static int[][] board;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        int[] line = new int[N];
//        int answer = 0;
//        for(int i = 0; i < N; i++) {
//            line = board[i];
//            isVisited = new boolean[N];
//            if(canThrough(line)) {
//                answer++;
//            }
//        }
//
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < N; j++) {
//                line[j] = board[j][i];
//            }
//
//            isVisited = new boolean[N];
//            if(canThrough(line)) {
//                answer++;
//            }
//        }

        int answer = 0;
        for(int i = 0; i < N; i++) {
            int[] line = board[i];
            isVisited = new boolean[N];
            if(canThrough(line)) {
                answer++;
            }
        }

        for(int i = 0; i < N; i++) {
            int[] line = new int[N];
            for(int j = 0; j < N; j++) {
                line[j] = board[j][i];
            }

            isVisited = new boolean[N];
            if(canThrough(line)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean canThrough(int[] line) {

        for(int i = 0; i < N - 1; i++) {
            int nowPos = line[i];
            int nextPos = line[i + 1];

            if(nowPos == nextPos) continue;

            if(Math.abs(nextPos - nowPos) > 1) return false;

            if(nowPos > nextPos) {
                for(int j = 1; j <= L; j++) {
                    int idx = i + j;
                    if(idx >= N || isVisited[idx] || line[idx] != nextPos) return false;
                }

                for(int j = 1; j <= L; j++) {
                    int idx = i + j;
                    isVisited[idx] = true;
                }

            } else {

                for(int j = 0; j < L; j++) {
                    int idx = i - j;
                    if(idx < 0 || isVisited[idx] || line[idx] != nowPos) return false;
                }

                for(int j = 0; j < L; j++) {
                    int idx = i - j;
                    isVisited[idx] = true;
                }

            }
        }

        return true;
    }

}