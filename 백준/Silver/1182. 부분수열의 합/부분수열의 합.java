import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(n, 0, s, 0, arr);
        System.out.println(s == 0 ? answer - 1 : answer);
    }

    static void dfs(int n, int depth, int target, int sum, int[] arr) {
        if (n == depth) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(n, depth + 1, target, sum + arr[depth], arr);
        dfs(n, depth + 1, target, sum, arr);
    }
}
