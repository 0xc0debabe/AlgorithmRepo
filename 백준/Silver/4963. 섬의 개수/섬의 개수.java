import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] island;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            island = new int[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (dfs(i, j)) answer++;
                }
            }

            System.out.println(answer);
        }
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || y < 0 || y >= h || x >= w || island[x][y] == 0) {
            return false;
        }

        island[x][y] = 0;

        dfs(x - 1, y - 1);
        dfs(x - 1, y);
        dfs(x - 1, y + 1);
        dfs(x, y - 1);
        dfs(x, y + 1);
        dfs(x + 1, y - 1);
        dfs(x + 1, y);
        dfs(x + 1, y + 1);
        return true;
    }
}
