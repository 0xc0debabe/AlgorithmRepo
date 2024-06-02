import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] L = new int[n];
        L[0] = a[0];
        int result = L[0];
        for (int i = 1; i < n; i++) {
            L[i] = Math.max(a[i], L[i - 1] + a[i]);
            result = Math.max(result, L[i]);
        }

        int[] R = new int[n];
        R[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(a[i], R[i + 1] + a[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int temp = L[i - 1] + R[i + 1];
            result = Math.max(result, temp);
        }

        System.out.println(result);
                


    }
}