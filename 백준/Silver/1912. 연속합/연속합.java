import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] leftDp = new int[n + 1];
        int[] right = new int[n + 1];
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -2002;
        for (int i = 1; i <= n; i++) {
            if (leftDp[i - 1] + arr[i] > arr[i]) {
                leftDp[i] = leftDp[i - 1] + arr[i];
            } else {
                leftDp[i] = arr[i];
            }

            if (leftDp[i] > max) {
                max = leftDp[i];
            }
        }

        System.out.println(max);
    }
}