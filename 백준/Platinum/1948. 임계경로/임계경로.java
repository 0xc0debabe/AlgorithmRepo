import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Node>> lists = new ArrayList<>();
        List<List<Node>> revLists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
            revLists.add(new ArrayList<>());
        }
        int[] arr = new int[n + 1];

        StringTokenizer stk;
        for (int i = 1; i <= m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken());

            lists.get(start).add(new Node(end, time));
            revLists.get(end).add(new Node(start, time));
            arr[end]++;
        }

        stk = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(stk.nextToken());
        int endDosi = Integer.parseInt(stk.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startDosi);
        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node next : lists.get(now)) {
                arr[next.end]--;
                result[next.end] = Math.max(result[next.end], result[now] + next.time);
                if (arr[next.end] == 0) {
                    queue.offer(next.end);
                }
            }
        }

        int resultCount = 0;
        boolean[] visited = new boolean[n + 1];
        queue = new LinkedList<>();
        queue.offer(endDosi);
        visited[endDosi] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (Node next : revLists.get(now)) {
                if (result[next.end] + next.time == result[now]) {
                    resultCount++;
                    if (!visited[next.end]) {
                        visited[next.end] = true;
                        queue.offer(next.end);
                    }
                }
            }
        }
        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}

class Node {
    int end;
    int time;

    public Node(int targetNode, int time) {
        this.end = targetNode;
        this.time = time;
    }
}

