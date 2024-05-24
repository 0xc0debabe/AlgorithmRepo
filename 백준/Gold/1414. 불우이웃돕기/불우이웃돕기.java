import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            char[] charArray = s.toCharArray();

            for (int j = 1; j <= charArray.length; j++) {
                char c = charArray[j - 1];
                int w = 0;

                if (c >= 'a' && c <= 'z') {
                    w = c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    w = c - 'A' + 27;
                }

                if (i != j && w != 0) pq.add(new Node(i, j, w));
                sum += w;
            }
        }

        int cnt = 0;
        int result = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result += now.w;
                cnt++;
            }
        }


        System.out.println((n - 1) == cnt ? sum - result : -1);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }


}

class Node {
    int s, e, w;

    public Node(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }
}