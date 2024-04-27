import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        lists = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            lists[from].add(to);
            lists[to].add(from);
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i]) {
                answer++;
                dfs(i);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int idx) {
        if (isVisited[idx]) {
            return;
        }
        isVisited[idx] = true;
        for (int value : lists[idx]) {
            if (!isVisited[value]) {
                dfs(value);
            }
        }
    }
}
