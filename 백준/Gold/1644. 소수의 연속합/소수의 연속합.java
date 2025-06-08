import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = 4_000_001;
        boolean[] isPrime = new boolean[len];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < len; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < len; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < len; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        int n = Integer.parseInt(br.readLine());
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= n) {
                sum -= primes.get(left);
                left++;
            } else if (right == primes.size()) {
                break;
            } else {
                sum += primes.get(right);
                right++;
            }

            if (sum == n) {
                count++;
            }
        }

        System.out.println(count);
    }

}