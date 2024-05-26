import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int idx = 1;
        int answer = 1;
        int tmp = 1;
        for (int i = n; i > n - k; i--) {
            answer *= i % 10_007;
            tmp *= idx++ % 10_007;
        }

        System.out.println(answer / tmp % 10_007);
    }
}