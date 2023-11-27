package Gold.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stargazing10 {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }
        star(arr, n / 3);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    static void star(char[][] chars, int n) {
        if (n >= 1) {
            for (int i = n; i < 2 * n; i++) {
                for (int j = n; j < 2 * n; j++) {
                    chars[i][j] = ' ';
                }
            }
            star(chars, n / 3);
        }
    }
}
