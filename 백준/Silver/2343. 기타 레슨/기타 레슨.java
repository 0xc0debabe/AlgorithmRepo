import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] numCourse = new int[n];
        int start = 0;
        int end = 0;
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numCourse[i] = Integer.parseInt(stk.nextToken());
            if (start < numCourse[i]) {
                start = numCourse[i];
            }
            end = end + numCourse[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + numCourse[i] > mid) {
                    cnt++;
                    sum = 0;
                }
                sum = sum + numCourse[i];
            }
            if (sum != 0) {
                cnt++;
            }
            if (cnt > m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}