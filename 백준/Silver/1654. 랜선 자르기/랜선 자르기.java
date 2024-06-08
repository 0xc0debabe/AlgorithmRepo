import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }
        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i] / mid;
            }
            if (sum >= k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}