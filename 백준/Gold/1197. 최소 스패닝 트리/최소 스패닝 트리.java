import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] parent;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        parent = new int[n + 1];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }
        int useNode = 0;
        int result = 0;
        while (useNode < n - 1) {
            Node now = pq.poll();
            if (find(now.start) != find(now.end)) {
                union(now.start, now.end);
                result = result + now.weight;
                useNode++;
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b){ parent[b] = a;}

    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}

class Node{
    int start, end, weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}