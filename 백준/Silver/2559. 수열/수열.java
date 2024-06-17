import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.MIN_VALUE;

        int left = 0;
        int right = 0;
        int sum = 0;
        while (right <= n) {
            if (right - left < m) {
                sum += arr[right];
                right++;
            } else {
                answer = Math.max(answer, sum);
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(answer);
    }
}