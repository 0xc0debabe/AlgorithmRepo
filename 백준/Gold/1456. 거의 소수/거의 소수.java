import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long start = Long.parseLong(stk.nextToken());
        long end = Long.parseLong(stk.nextToken());

        boolean[] isPrime = new boolean[10000001];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (!isPrime[i]) continue;

            for (int j = 2 * i; j < isPrime.length; j += i) {
                isPrime[j] = false;
            }
        }


        int cnt = 0;
        for (int i = 2; i < 10000001; i++) {
            if (!isPrime[i]) continue;
            if (i > end) break;

            if (isPrime[i]) {
                int pow = 2;

                while (true) {
                    long tmp = (long) Math.pow(i, pow);
                    if (tmp >= Math.pow(10, 17)) {
                        break;
                    }

                    if (tmp <= end && tmp >= start) {
                        cnt++;
                    }
                    pow++;
                }

            }
        }
        System.out.println(cnt);
    }
}
