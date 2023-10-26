package Silver.II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bertrand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[246913];

        for (int i = 2; i <= 246912; i++) {
            if (!isPrime[i]) {
                for (int j = i * 2; j <= 246912; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                break;
            }

            int cnt = 0;
            for (int i = a + 1; i <= 2 * a; i++) {
                if (!isPrime[i]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
