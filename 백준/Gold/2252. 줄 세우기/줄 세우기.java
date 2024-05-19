import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        int[] arr = new int[n + 1];

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            lists.get(start).add(end);
            arr[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int value : lists.get(now)) {
                arr[value]--;
                if (arr[value] == 0) {
                    queue.offer(value);
                }
            }
        }
        System.out.println(sb);
    }
}
