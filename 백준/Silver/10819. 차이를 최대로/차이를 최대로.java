import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, blank;
    static int n;
    static int answer = 0;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        blank = new int[n];
        isVisited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(answer);
    }

    static void dfs(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += Math.abs(blank[i] - blank[i - 1]);
            }
            answer = Math.max(answer, sum);
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