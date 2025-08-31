import java.io.*;
import java.util.*;

class Edge {
    int from, to, weight;

    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int N, M, W;
    static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            // 도로 입력 (양방향)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            // 웜홀 입력 (단방향, 시간 감소)
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, -T));
            }

            if (hasNegativeCycle()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }

    static boolean hasNegativeCycle() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0); // 모든 노드 0으로 초기화

        // N번 반복
        for (int i = 1; i <= N; i++) {
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.weight) {
                    dist[e.to] = dist[e.from] + e.weight;
                    if (i == N) return true; // N번째 반복에서 갱신되면 음수 사이클 존재
                }
            }
        }

        return false;
    }
}