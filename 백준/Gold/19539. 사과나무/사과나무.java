import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        long ones = 0;
        long twos = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        for (int i = 0; i < n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
            ones += h[i] % 2;
            twos += h[i] / 2;
            total += h[i];
        }

        if (total % 3 != 0) {
            System.out.println("NO");
            return;
        }

        long ops = total / 3;

        if (ones <= ops && ops <= twos) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}