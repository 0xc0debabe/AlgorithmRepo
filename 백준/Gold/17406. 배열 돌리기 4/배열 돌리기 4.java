import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static int[][] orders;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        orders = new int[K][3];
        isVisited = new boolean[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i][0] = Integer.parseInt(st.nextToken());
            orders[i][1] = Integer.parseInt(st.nextToken());
            orders[i][2] = Integer.parseInt(st.nextToken());
        }

        dfs(board, 0);
        System.out.println(answer);
    }

    private static void dfs(int[][] board, int depth) {
        if(depth == K) {
            answer = Math.min(answer, findMinValue(board));
            return;
        }
        for(int i = 0; i < K; i++) {
            if(!isVisited[i]) {
                int[][] newBoard = copy(board);
                int r = orders[i][0] - 1;
                int c = orders[i][1] - 1;
                int s = orders[i][2];
                for(int j = 1; j <= s; j++) {
                    rotate(r - j, c - j, r + j, c + j, newBoard);
                }
                isVisited[i] = true;
                dfs(newBoard, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private static int[][] copy(int[][] board) {
        int[][] newBoard = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    private static int findMinValue(int[][] board) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int rowSum = Arrays.stream(board[i]).sum();
            min = Math.min(min, rowSum);
        }

        return min;
    }

    private static void rotate(int sr, int sc, int er, int ec, int[][] board) {
        int tmp = board[sr][sc];
        for(int i = sr; i < er; i++) {
            board[i][sc] = board[i + 1][sc];
        }
        for(int i = sc; i < ec; i++) {
            board[er][i] = board[er][i + 1];
        }
        for(int i = er; i > sr; i--) {
            board[i][ec] = board[i - 1][ec];
        }
        for(int i = ec; i > sc + 1; i--) {
            board[sr][i] = board[sr][i - 1];
        }
        board[sr][sc + 1] = tmp;
    }

}