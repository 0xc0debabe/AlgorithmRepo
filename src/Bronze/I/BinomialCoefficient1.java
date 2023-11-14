package Bronze.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinomialCoefficient1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int answer = 1;

        for (int i = n; i > n - k; i--) {
            answer *= i;
        }

        for (int i = k; i > 0; i--) {
            answer /= i;
        }
        System.out.println(answer);

    }
}
