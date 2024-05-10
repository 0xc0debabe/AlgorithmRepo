import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        boolean[] isPrime = new boolean[m + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i <= m; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j <= m; j += i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i <= m; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}