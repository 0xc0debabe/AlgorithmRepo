import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        long max = 0;
//        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
//            min = Math.min(arr[i], min);
        }
        long target = Long.parseLong(br.readLine());

        long left = 0;
        long right = max;
        while (left <= right) {
            long mid = left + (right - left) / 2;

            long[] tmp = arr.clone();
            for (int i = 0; i < n; i++) {
                if (tmp[i] > mid) {
                    tmp[i] = mid;
                }
            }
            long sum = Arrays.stream(tmp).sum();

            if (target >= sum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);
    }
}