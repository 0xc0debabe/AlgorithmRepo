import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int n;
    static int cnt = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        System.out.println(cnt);
    }

    static void nQueen(int col) {
        if (col == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[col] = i;
            if (possible(col)) {
                nQueen(col + 1);
            }
        }

    }

    static boolean possible(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[i] == arr[col]) {
                return false;
            } else if (Math.abs(arr[i] - arr[col]) == Math.abs(col - i)) {
                return false;
            }
        }
        return true;
    }
}
