import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int n;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        nQueen(0);
        System.out.println(cnt);
    }

    static void nQueen(int index) {
        if (index == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[index] = i;
            if (Possibility(index)) {
                nQueen(index + 1);
            }
        }
    }

    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}