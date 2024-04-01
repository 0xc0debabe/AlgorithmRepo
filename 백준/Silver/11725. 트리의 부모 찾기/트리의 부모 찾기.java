import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int[] answer = new int[n + 1];
        List<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer stk;
        for (int i = 1; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(stk.nextToken());
            int num2 = Integer.parseInt(stk.nextToken());

            lists[num1].add(num2);
            lists[num2].add(num1);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : lists[cur]) {
                if (visited[next]) {
                    continue;
                }

                queue.add(next);
                visited[next] = true;
                answer[next] = cur;
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}