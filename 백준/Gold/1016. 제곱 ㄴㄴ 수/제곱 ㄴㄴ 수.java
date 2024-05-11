import javax.swing.plaf.IconUIResource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
//    10^12 -> 10^6 백만
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        long min = Long.parseLong(stk.nextToken());
        long max = Long.parseLong(stk.nextToken());

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long startIdx = min / pow;
            if (min % pow != 0) {
                startIdx++;
            }
            for (long j = startIdx; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}