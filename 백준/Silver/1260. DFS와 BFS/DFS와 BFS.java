import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());

            lists[from].add(to);
            lists[to].add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(lists[i]);
        }

        dfs(v);
        sb.append("\n");

        Arrays.fill(visited, false);
        bfs(v);

        System.out.println(sb);
    }

    static void dfs(int n) {
        sb.append(n).append(" ");
        visited[n] = true;

        for (int value : lists[n]) {
            if (!visited[value]) {
                dfs(value);
            }
        }

    }

    static void bfs(int n) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(n);
        visited[n] = true;

        while (!deque.isEmpty()) {
            int num = deque.pollLast();
            sb.append(num).append(" ");

            for (int value : lists[num]) {
                if (!visited[value]) {
                    visited[value] = true;
                    deque.addFirst(value);
                }
            }
        }
    }

}
