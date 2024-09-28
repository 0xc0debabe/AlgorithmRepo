import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Node>> list = new ArrayList<>();
    static int[] dist;
    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(to, weight));
            list.get(to).add(new Node(from, weight));
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, bfs(i));
        }

        System.out.println(answer);
    }

    static int bfs(int start) {
        dist = new int[n + 1];
        isVisited = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        isVisited[start] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : list.get(now.vertex)) {
                if (isVisited[next.vertex]) continue;

                if (dist[next.vertex] > dist[now.vertex] + next.weight && dist[now.vertex] + next.weight <= m) {
                    dist[next.vertex] = dist[now.vertex] + next.weight;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                sum += arr[i];
            }
        }

        return sum;
    }
}

class Node {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}