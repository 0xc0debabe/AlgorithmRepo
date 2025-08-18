import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        // 루트 1에서 DFS로 depth와 parent 계산
        dfs(1, 0);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int node, int d) {
        visited[node] = true;
        depth[node] = d;

        for (int next : tree[node]) {
            if (!visited[next]) {
                parent[next] = node;
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        // 깊이가 더 깊은 노드를 맞춤
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 깊이 맞추기
        while (depth[a] > depth[b]) {
            a = parent[a];
        }

        // 공통 조상 찾기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}