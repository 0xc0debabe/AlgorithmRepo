package Gold.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stargazing10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] starArr;

            int n = Integer.parseInt(br.readLine());
            starArr = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    starArr[i][j] = ' ';
                }
            }

            drawStars(starArr, 0, 0, n);

            for (int i = 0; i < n; i++) {
                sb.append(starArr[i]);
                sb.append('\n');
            }
            System.out.println(sb);
        }

    static void drawStars(char[][] starArr, int x, int y, int size) {
        if (size == 1) {
            starArr[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                drawStars(starArr, x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}