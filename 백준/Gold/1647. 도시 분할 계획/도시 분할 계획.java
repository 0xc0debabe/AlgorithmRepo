import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Node>> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(s).add(new Node(e, c));
            list.get(e).add(new Node(s, c));
        }

        System.out.println(prim());
    }

    static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(1, 0));
        boolean[] isVisited = new boolean[n + 1];
        int max = 0;
        int sum = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (isVisited[now.vertex]) continue;
            sum += now.cost;
            if (max < now.cost) {
                max = now.cost;
            }

            isVisited[now.vertex] = true;

            for (Node next : list.get(now.vertex)) {
                pq.add(new Node(next.vertex, next.cost));
            }
        }

        return sum - max;
    }
}

class Node {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}
