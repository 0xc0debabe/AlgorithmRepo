import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        while (k > 0) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] <= k) {
                    answer++;
                    k -= arr[i];
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}