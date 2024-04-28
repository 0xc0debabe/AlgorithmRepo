import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(stk.nextToken());
        int ySize = Integer.parseInt(stk.nextToken());
        visited = new boolean[xSize + 2][ySize + 2];
        board = new int[xSize + 2][ySize + 2];


        for (int i = 0; i < xSize; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < split.length; j++) {
                board[i + 1][j + 1] = Integer.parseInt(split[j]);
            }
        }


        dfs(1, 1);
        System.out.println(board[xSize][ySize]);
    }

    static void dfs(int currPosX, int currPosY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{currPosX, currPosY});
        visited[currPosX][currPosY] = true;

        while (!deque.isEmpty()) {
            int[] currPos = deque.pollLast();
            for (int i = 0; i < 4; i++) {
                int nextPosX = dx[i] + currPos[0];
                int nextPosY = dy[i] + currPos[1];

                if (board[nextPosX][nextPosY] == 1) {
                    visited[nextPosX][nextPosY] = true;
                    board[nextPosX][nextPosY] = board[currPos[0]][currPos[1]] + 1;
                    deque.addFirst(new int[]{nextPosX, nextPosY});
                }
            }

        }
    }
}
