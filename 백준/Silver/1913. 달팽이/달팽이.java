import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] board;
    static int cnt = 1;
    static int n, target;
    static int x, y = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        board = new int[n][n];
        board[n / 2][n / 2] = cnt++;
        solution(n / 2, n / 2, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target) {
                    x = i + 1;
                    y = j + 1;
                }
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(x).append(" ").append(y);
        System.out.println(sb);
    }

    static void solution(int r, int c, int tmp) {
        for (int i = 0; i < tmp; i++) {
            if (cnt >= n * n + 1) return;
            r--;
            board[r][c] = cnt++;
        }

        for (int i = 0; i < tmp; i++) {
            c++;
            board[r][c] = cnt++;
        }

        tmp++;

        for (int i = 0; i < tmp; i++) {
            r++;
            board[r][c] = cnt++;
        }

        for (int i = 0; i < tmp; i++) {
            c--;
            board[r][c] = cnt++;
        }

        solution(r, c, tmp + 1);
    }
}
