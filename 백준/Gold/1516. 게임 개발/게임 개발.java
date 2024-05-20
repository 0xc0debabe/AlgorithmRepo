import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        int[] arr = new int[n + 1];
        int[] timeArr = new int[n + 1];

        StringTokenizer stk;
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            timeArr[i] = Integer.parseInt(stk.nextToken());

            while (true) {
                int to = Integer.parseInt(stk.nextToken());
                if (to == -1) break;
                lists.get(to).add(i);
                arr[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        int[] answer = new int[n + 1];
        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int value : lists.get(poll)) {
                arr[value]--;
                answer[value] = Math.max(answer[value], answer[poll] + timeArr[poll]);
                if (arr[value] == 0) {
                    queue.offer(value);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int ans = answer[i] + timeArr[i];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
