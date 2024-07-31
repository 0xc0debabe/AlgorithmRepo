import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] isVisited;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(s).add(new Node(e, c));
            list.get(e).add(new Node(s, c));
        }

        System.out.println(prim());
    }

    static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.coast - y.coast);
        pq.add(new Node(1, 0));
        int totalCoast = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int vertex = now.vertex;
            int coast = now.coast;

            if (isVisited[vertex]) continue;

            isVisited[vertex] = true;
            totalCoast += coast;

            for (Node next : list.get(vertex)) {
                if (!isVisited[next.vertex]) {
                    pq.add(next);
                }
            }
        }

        return totalCoast;
    }
}

class Node {
    int vertex;
    int coast;

    public Node(int vertex, int coast) {
        this.vertex = vertex;
        this.coast = coast;
    }
}