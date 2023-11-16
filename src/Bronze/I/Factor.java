package Bronze.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Factor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int min, max;
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        if (n == 1) {
            min = arr[0];
            max = arr[0];
        } else {
            min = 0;
            max = 0;
        }

        for (int i = 0; i < n - 1; i++) {
            int tmp = 0;
            if (arr[i] < arr[i + 1]) {
                min = arr[i];
                tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            } else min = arr[i + 1];
        }

        for (int i = 0; i < n - 1; i++) {
            int tmp = 0;
            if (arr[i] > arr[i + 1]) {
                max = arr[i];
                tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            } else max = arr[i + 1];
        }
        System.out.println(min * max);
    }
}
