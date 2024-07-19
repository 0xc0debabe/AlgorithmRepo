import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, x, y, k;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();
    static int[] dice = new int[7];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            canMove(x, y, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    static void canMove(int row, int col, int dir) {
        int nx = row + dx[dir];
        int ny = col + dy[dir];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
            sb.append(move(nx, ny, dir)).append("\n");
            x = nx; y = ny;
        }
    }

    static int move(int nx, int ny, int type) {
        int tmp = dice[3];

        switch (type) {
            case 1:
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;

            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;

            case 3:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;

            case 4:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
        }

        if (board[nx][ny] == 0) {
            board[nx][ny] = dice[6];
        } else {
            dice[6] = board[nx][ny];
            board[nx][ny] = 0;
        }


        return dice[3];
    }

}
