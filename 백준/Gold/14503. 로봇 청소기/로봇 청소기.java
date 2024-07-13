import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int idx = 0;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dx2 = {-1, 0, 1, 0};
    static int[] dy2 = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        board = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int robotRow = Integer.parseInt(st.nextToken());
        int robotCol = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(robotRow, robotCol, robotDir);
        System.out.println(answer);
    }

    static void solution(int robotRow, int robotCol, int robotDir) {
        if (board[robotRow][robotCol] == 0) {
            board[robotRow][robotCol] = 2;
            answer++;
        }

        if (isClean(robotRow, robotCol)) {
            if (canBack(robotRow, robotCol, robotDir)) {
                int nx = robotRow + dx[robotDir];
                int ny = robotCol + dy[robotDir];

                solution(nx, ny, robotDir);
            } else {
                return;
            }
        } else {
            boolean check = false;
            int nx = 0; int ny = 0;
            for (int i = 0; i < 4; i++) {
                robotDir = (robotDir + 3) % 4;
                nx = robotRow + dx2[robotDir];
                ny = robotCol + dy2[robotDir];

                if (board[nx][ny] == 0) {
                    check = true;
                    break;
                }
            }

            if (check) solution(nx, ny, robotDir);
        }
    }

    static boolean isClean(int robotRow, int robotCol) {
        boolean clean = true;

        for (int i = 0; i < 4; i++) {
            int nx = robotRow + dx[i];
            int ny = robotCol + dy[i];

            if (board[nx][ny] == 0) {
                clean = false;
                break;
            }
        }

        return clean;
    }

    static boolean canBack(int robotRow, int robotCol, int robotDir) {
        int nx = robotRow + dx[robotDir];
        int ny = robotCol + dy[robotDir];

        if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] != 1) {
            return true;
        }

        return false;
    }

}