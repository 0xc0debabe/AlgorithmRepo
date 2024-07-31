import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] isVisited;
    static int[] dist;
    static int[] asdf;
    static int cnt = 0;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }

        dist = new int[n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            asdf = new int[list.get(i).size()];
            cnt = 0;
            dfs(i, i);
            Arrays.sort(asdf);
            int sum = 0;
            if (asdf.length > 0) {
                sum = asdf[asdf.length - 1];
            }
            if (asdf.length > 1) {
                sum += asdf[asdf.length - 2];
            }
            answer = Math.max(answer, sum);
            Arrays.fill(dist, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int start, int idx) {
        if (list.get(start).isEmpty()) return;

        for (Node node : list.get(start)) {
            dfs(node.vertex, idx);

            if (start == idx) {
                asdf[cnt++] = dist[node.vertex] + node.weight;
            } else {
                if (dist[start] < dist[node.vertex] + node.weight) {
                    dist[start] = dist[node.vertex] + node.weight;
                }
            }
        }
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