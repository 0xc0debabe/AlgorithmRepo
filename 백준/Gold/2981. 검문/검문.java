import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int val = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            val = gcd(val, arr[i] - arr[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= val; i++) {
            if (val % i == 0) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}
