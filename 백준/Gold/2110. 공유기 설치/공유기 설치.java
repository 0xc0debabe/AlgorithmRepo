import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int left = 1;
        int right = max - min;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 1;
            int start = arr[0];
            int idx = 1;

            while (idx < arr.length) {
                if (arr[idx] - start >= mid) {
                    start = arr[idx];
                    cnt++;
                }
                idx++;

            }

            if (cnt < target) {
                right = mid - 1;
                  
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
