import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int idx = 2;
        String answer = "";

        while (true) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(idx); i++) {
                if (idx % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (idx >= n) {
                if (isPrime) {
                    String tmp1 = String.valueOf(idx);
                    StringBuilder sb = new StringBuilder(tmp1);
                    String tmp2 = sb.reverse().toString();
                    if (tmp1.equals(tmp2)) {
                        answer = tmp1;
                        break;
                    }
                }
            }

            idx++;
        }

        System.out.println(answer);
    }
}