import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char[][] map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n * 2 - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }

        star(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int r, int c, int N) {
        if (N == 3) { // k=0인 가장 작은 삼각형일 때 별찍기
            map[r][c] = '*';
            map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
            return;
        } else { // 큰 삼각형 세개로 다시 쪼갬
            int cut = N / 2;
            star(r, c, cut); // 제일 위에 삼각형
            star(r + cut, c - cut, cut); // 아래 왼쪽 삼각형
            star(r + cut, c + cut, cut); // 아래 오른쪽 삼각형
        }
    }
}
