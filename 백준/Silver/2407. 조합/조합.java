import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger b1 = BigInteger.ONE;
        BigInteger b2 = BigInteger.ONE;

        for (int i = n; i > n - m; i--) {
            b1 = b1.multiply(new BigInteger(String.valueOf(i)));
            b1 = b1.divide(b2);
            b2 = b2.add(BigInteger.ONE);
        }
        System.out.println(b1);
    }

    static void fastPow(int num, int pow) {

    }
}
