import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(stk.nextToken());
        long num2 = Long.parseLong(stk.nextToken());
        long answer = gcd(num1, num2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer; i++) {
            sb.append(1);
        }

        System.out.println(sb);
    }
    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}