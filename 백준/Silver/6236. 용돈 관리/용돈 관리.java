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
        int[] arr = new int[n];
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int left = max;
        int right = sum;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (valid(arr, mid, m)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean valid(int[] arr, int mid, int k) {
        int count = 1;
        int rest = mid;
        for (int j : arr) {
            if (j > rest) {
                rest = mid;
                count++;
            }

            rest -= j;
        }

        return count <= k;
    }

}