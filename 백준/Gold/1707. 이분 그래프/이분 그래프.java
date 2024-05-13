import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] lists;
    static int[] group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(stk.nextToken());
            int e = Integer.parseInt(stk.nextToken());

            lists = new List[v + 1];
            for (int j = 1; j <= v; j++) {
                lists[j] = new ArrayList<>();
            }
            group = new int[v + 1];

            for (int j = 1; j <= e; j++) {
                stk = new StringTokenizer(br.readLine());
                int vertex = Integer.parseInt(stk.nextToken());
                int edge = Integer.parseInt(stk.nextToken());
                lists[vertex].add(edge);
                lists[edge].add(vertex);
            }

            boolean possible = false;
            for (int j = 1; j <= v; j++) {
                if (group[j] == 0) {
                    possible = bfs(j);
                }
                if (!possible) {
                    break;
                }
            }

            group = new int[v + 1];
            sb.append(possible ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    public static boolean bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        group[start] = 1;
        boolean check = true;

        while (!deque.isEmpty()) {
            int poll = deque.pollLast();

            for (int item : lists[poll]) {
                if (group[item] == 0) {
                    deque.addFirst(item);
                    group[item] = (group[poll] == 1) ? 2 : 1;
                } else {
                    if (group[item] == group[poll]) {
                        check = false;
                    }
                }

                if (!check) break;
            }

            if (!check) break;
        }

        return check;
    }

}
