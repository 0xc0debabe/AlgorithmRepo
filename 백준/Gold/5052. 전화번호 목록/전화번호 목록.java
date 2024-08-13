import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] blank = new String[n];
            for (int j = 0; j < n; j++) {
                blank[j] = br.readLine();
            }
            Arrays.sort(blank);

            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (blank[j + 1].startsWith(blank[j])) flag = true;
                if (flag) break;
            }

            if (flag) sb.append("NO").append('\n');
            else sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }
}
