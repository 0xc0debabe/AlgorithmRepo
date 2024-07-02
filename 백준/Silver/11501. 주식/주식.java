import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = Integer.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                if (max > arr[j]) {
                    answer = answer + max - arr[j];
                } else if (max < arr[j]) {
                    max = arr[j];
                } 
            }

            System.out.println(answer);
        }
    }
}