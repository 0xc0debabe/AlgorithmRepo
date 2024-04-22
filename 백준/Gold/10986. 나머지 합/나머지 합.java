import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        long[] s = new long[n];
        long[] c = new long[m];
        long answer = 0;
        stk = new StringTokenizer(br.readLine());
        s[0] = Integer.parseInt(stk.nextToken());
        for (int i = 1; i < n; i++) {
            s[i] += s[i - 1] + Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int reminder = (int) (s[i] % m);
            if (reminder == 0) answer++;
            c[reminder]++;
        }

        for (int i = 0; i < m; i++) {
            if (c[i] > 1) {
                answer = answer + (c[i] * (c[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
