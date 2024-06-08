import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] tree = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        long left = 0;
        long right = max;
        boolean check = false;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            if (sum <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
            if (sum == m) {
                check = true;
            }
        }

        System.out.println(check ? left : left - 1);
    }

}