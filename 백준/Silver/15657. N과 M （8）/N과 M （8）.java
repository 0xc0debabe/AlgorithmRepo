import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[] arr, blank;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        blank = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int idx) {
        if (depth == m) {
            for (int v : blank) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
                blank[depth] = arr[i];
                dfs(depth + 1, i);
        }
    }
}