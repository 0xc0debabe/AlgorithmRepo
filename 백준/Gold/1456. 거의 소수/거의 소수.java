import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long n = Long.parseLong(stk.nextToken());
        long m = Long.parseLong(stk.nextToken());
        long[] isPrime = new long[10000001];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i] == 0) continue;

            for (int j = 2 * i; j < isPrime.length; j += i) {
                isPrime[j] = 0;
            }
        }
        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (isPrime[i] != 0) {
                long temp = isPrime[i];
                while ((double) isPrime[i] <= (double) m / (double) temp) {
                    if ((double) isPrime[i] >= (double) n / (double) temp) {
                        cnt++;
                    }
                    temp = temp * isPrime[i];
                }
            }
        }
        System.out.println(cnt);
    }
}