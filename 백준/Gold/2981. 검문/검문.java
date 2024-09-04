import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (i * i == val) {
                list.add(i);
            } else if (val % i == 0) {
                list.add(i);
                list.add(val / i);
            }
        }
        Collections.sort(list);
        for (int v : list) {
            sb.append(v).append(' ');
        }
        sb.append(val);
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
