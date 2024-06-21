import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int block = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
                min = Math.min(min, board[i][j]);
            }
        }


        int answer = Integer.MAX_VALUE;
        int height = 0;
        for (int k = min; k <= max; k++) {
            int nowBlock = block;
            int time = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] > k) {
                        nowBlock += board[i][j] - k;
                        time += (board[i][j] - k) * 2;
                    } else if (board[i][j] < k) {
                        nowBlock -= k - board[i][j];
                        time += k - board[i][j];
                    }
                }
            }

            if (nowBlock >= 0) {
                if (answer >= time) {
                    answer = time;
                    height = k;
                }
            }
        }

        System.out.print(answer + " " + height);
    }
}