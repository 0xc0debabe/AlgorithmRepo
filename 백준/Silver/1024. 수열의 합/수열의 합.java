import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static long idx = 1;
    static long sum = 0;
    static int n;
    static long l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        solution();
        StringBuilder sb = new StringBuilder();
        if (sum <= n && idx <= 100) {
            long answer = (n - sum) / idx;
            for (int i = 0; i < idx; i++) {
                sb.append(answer).append(" ");
                answer++;
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
    }

    static void solution() {
        if (idx > 100) return;


        if ((n - sum) % idx == 0 && l <= idx) {
            return;
        }

        sum += idx;
        idx += 1;
        solution();
    }
}
