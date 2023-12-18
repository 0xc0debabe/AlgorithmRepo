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

        StringBuilder sb = new StringBuilder();

        sb.append(n + m).append("\n");
        sb.append(n - m).append("\n");
        sb.append(n * m).append("\n");
        sb.append(n / m).append("\n");
        sb.append(n % m);
        System.out.println(sb);

    }
}
