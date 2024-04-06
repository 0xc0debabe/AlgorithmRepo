import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        System.out.println(BigInteger.TWO.pow(k).subtract(BigInteger.ONE));
        hanoi(k, 1, 2, 3);
        System.out.println(sb);
    }

    public static void hanoi(int k, int s, int m, int t) {
        if (k > 20) {
            return;
        }
        if (k == 1) {
            sb.append(s).append(" ").append(t).append("\n");
            return;
        }

        hanoi(k - 1, s, t, m);
        sb.append(s).append(" ").append(t).append("\n");
        hanoi(k - 1, m, s, t);
    }
}
