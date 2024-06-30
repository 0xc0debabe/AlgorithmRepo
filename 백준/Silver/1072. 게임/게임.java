import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long z = y * 100 / x;

        int left = 0;
        int right = 1_000_000_000;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long comp = (y + mid) * 100 / (x + mid);

            if (comp <= z) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left == 1_000_000_001) {
            System.out.println(-1);
        } else {
            System.out.println(left);
        }
    }
}