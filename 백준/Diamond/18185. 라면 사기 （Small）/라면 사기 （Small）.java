import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int min;

            if (arr[i + 1] > arr[i + 2]) {
                if (arr[i + 1] > 0 && arr[i] > 0) {
                    min = Math.min(arr[i], arr[i + 1] - arr[i + 2]);
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    answer += min * 5;
                }

                if (arr[i + 2] > 0 && arr[i + 1] > 0 && arr[i] > 0) {
                    min = Math.min(arr[i + 2], Math.min(arr[i], arr[i + 1]));
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    arr[i + 2] -= min;
                    answer += min * 7;
                }

                answer += arr[i] * 3;
                arr[i] = 0;
            } else {
                if (arr[i + 2] > 0 && arr[i + 1] > 0 && arr[i] > 0) {
                    min = Math.min(arr[i + 2], Math.min(arr[i], arr[i + 1]));
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    arr[i + 2] -= min;
                    answer += min * 7;
                }

                if (arr[i + 1] > 0 && arr[i] > 0) {
                    min = Math.min(arr[i + 1], arr[i]);
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    answer += min * 5;
                }

                answer += arr[i] * 3;
                arr[i] = 0;
            }
        }

        System.out.println(answer);
    }
}