import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;       // 현재 탐색 중인 경로에 있는지
    static boolean[] finished;      // 해당 노드의 탐색이 끝났는지
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];           // 1-based index
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            System.out.println(n - count);  // 전체 인원 - 사이클 인원
        }
    }

    private static void dfs(int current) {
        visited[current] = true;
        int next = arr[current];

        if (!visited[next]) {
            dfs(next);
        } else if (!finished[next]) {
            // 사이클 발견
            count++;  // current도 포함
            for (int i = next; i != current; i = arr[i]) {
                count++;
            }
        }

        finished[current] = true;
    }
}