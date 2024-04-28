import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(stk.nextToken());
        int ySize = Integer.parseInt(stk.nextToken());
        visited = new int[xSize + 2][ySize + 2];
        board = new int[xSize + 2][ySize + 2];


        for (int i = 0; i < xSize; i++) {
            String s = br.readLine();
            String[] split = s.split("");
            for (int j = 0; j < split.length; j++) {
                board[i + 1][j + 1] = Integer.parseInt(split[j]);
            }
        }

        final int MAX_VALUE = 10000;

        for (int i = 0; i < xSize + 2; i++) {
            for (int j = 0; j < ySize + 2; j++) {
                visited[i][j] = MAX_VALUE;
            }
        }


        visited[1][1] = 1;
        dfs(1, 1);
        System.out.println(visited[xSize][ySize]);
    }

    static void dfs(int currPosX, int currPosY) {
        for (int i = 0; i < 4; i++) {
            int nextPosX = dx[i] + currPosX;
            int nextPosY = dy[i] + currPosY;

            if (board[nextPosX][nextPosY] == 1) {
                if (visited[nextPosX][nextPosY] > visited[currPosX][currPosY] + 1) {
                    visited[nextPosX][nextPosY] = visited[currPosX][currPosY] + 1;
                    dfs(nextPosX, nextPosY);
                }
            }
        }
    }
}
