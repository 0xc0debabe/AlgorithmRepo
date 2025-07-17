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
        int k = Integer.parseInt(br.readLine());

        int[][] matrix = new int[m][n];
        int idx = 1;
        int r = m - 1;
        int c = 0;
        int range = n * m;

        int dir = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (range-- > 0) {
            matrix[r][c] = idx++;

            if (matrix[r][c] == k) {
                break;
            }

            int nr = r + dr[dir % 4];
            int nc = c + dc[dir % 4];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || matrix[nr][nc] != 0) {
                dir++;
                r += dr[dir % 4];
                c += dc[dir % 4];
                continue;
            }

            r = nr;
            c = nc;
        }

        boolean flag = false;
        int x = -1;
        int y = 1;
        for (int i = m - 1; i >= 0; i--) {
            x = 1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == k) {
                    flag = true;
                    break;
                }
                x++;
            }

            if (flag) break;
            y++;
        }

        if (!flag) {
            System.out.println(0);
        } else {
            System.out.println(x + " " + y);
        }

    }
}