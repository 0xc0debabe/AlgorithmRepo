import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int lcm = M * N / gcd(M, N);
            int n = 0;
            int ans = -1;
            while (n * M < lcm) {
                if ((n * M + x - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }
                n++;
            }

            System.out.println(ans);
        }

        System.out.println(sb);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}