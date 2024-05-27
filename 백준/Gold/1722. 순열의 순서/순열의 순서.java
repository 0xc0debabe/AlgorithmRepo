import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, q;
        long[] f = new long[21];
        int[] s = new int[21];
        boolean[] visited =new boolean[21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        q = Integer.parseInt(st.nextToken());
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1] * i;
        }
        if (q == 1) {
            long k = Long.parseLong(st.nextToken());
            for (int i = 1; i <= n; i++) {
                int cnt = 1;
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) continue;
                    if (k <= cnt * f[n - i]) {
                        k -= ((cnt - 1) * f[n - i]);
                        s[i] = j;
                        visited[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(s[i] + " ");
            }
        } else {
            long k = 1;
            for (int i = 1; i <= n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;
                for (int j = 1; j < s[i]; j++) {
                    if (!visited[j]) {
                        cnt++;
                    }
                }
                k += cnt * f[n - i];
                visited[s[i]] = true;
            }
            System.out.println(k);
        }
    }
}