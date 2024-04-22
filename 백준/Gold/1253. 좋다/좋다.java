import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(stk.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;

        for (int i = 0; i < n; i++) {
            long find = arr[i];
            int start_idx = 0;
            int end_idx = n - 1;

            while (start_idx < end_idx) {
                long sum = arr[start_idx] + arr[end_idx];

                if (sum == find) {
                    if (start_idx != i && end_idx != i) {
                        answer++;
                        break;
                    } else if (start_idx == i) {
                        start_idx++;
                    } else if (end_idx == i) {
                        end_idx--;
                    }
                } else if (sum < find) {
                    start_idx++;
                } else {
                    end_idx--;
                }
            }

        }

        System.out.println(answer);
    }
}
