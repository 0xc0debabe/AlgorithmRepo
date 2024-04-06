import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        System.out.println(nQueen(arr, 0, n));
    }

    public static int nQueen(int[] arr, int row, int end) {
        if (row >= end) {
            cnt++;
            return cnt;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[row] = i;
            if (isQueen(arr, row)) {
                nQueen(arr, row + 1, end);
            }
        }
        return cnt;
    }

    public static boolean isQueen(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || row - i == Math.abs(arr[i] - arr[row])) {
                return false;
            }
        }
        return true;
    }
}
