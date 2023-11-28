package Gold.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stargazing10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] stars = new char[N][N];

        // 배열 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                stars[i][j] = ' ';
            }
        }

        // 재귀 함수 호출
        drawStars(stars, 0, 0, N);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(stars[i]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    static void drawStars(char[][] stars, int row, int col, int size) {
        if (size == 1) {
            stars[row][col] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue; // 가운데 칸은 비워둠
                }
                drawStars(stars, row + i * newSize, col + j * newSize, newSize);
            }
        }
    }
}