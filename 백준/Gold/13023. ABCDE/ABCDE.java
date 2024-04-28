import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static boolean[] visited;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int fri = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            lists[fri].add(end);
            lists[end].add(fri);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            if (check) {
                break;
            }
        }

        System.out.println(check ? 1 : 0);
    }

    static void dfs(int n, int depth) {
        if (depth == 5 || check) {
            check = true;
            return;
        }

        visited[n] = true;
        for (int value : lists[n]) {
            if (!visited[value]) {
                dfs(value, depth + 1);
            }
        }
        visited[n] = false;
    }
}
