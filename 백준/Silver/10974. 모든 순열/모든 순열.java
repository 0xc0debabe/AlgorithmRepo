import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, blank;
    static int n;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        blank = new int[n];
        isVisited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == n) {
            for (int v : blank) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                blank[depth] = arr[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}