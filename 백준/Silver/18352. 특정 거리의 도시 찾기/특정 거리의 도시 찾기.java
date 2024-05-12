import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<Integer>[] lists;
    static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        isVisited = new int[n + 1];
        lists = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            lists[from].add(to);
        }

        bfs(x);

        StringBuilder sb = new StringBuilder();
        IntStream.range(1, isVisited.length)
                .filter(i -> isVisited[i] == k + 1)
                .forEach(i -> sb.append(i).append("\n"));

        if (sb.length() == 0) sb.append(-1);
        System.out.println(sb);
    }

    public static void bfs(int x) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);
        isVisited[x] = isVisited[x] + 1;

        while (!deque.isEmpty()) {
            int poll = deque.pollLast();
            for (int value : lists[poll]) {
                if (isVisited[value] == 0) {
                    deque.addFirst(value);
                    isVisited[value] = isVisited[poll] + 1;
                }
            }
        }

    }
}