import java.io.*;
import java.util.*;

class Main {
    static int N, M, W;
    static List<Edge> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.add(new Edge(from, to, weight));
                graph.add(new Edge(to, from, weight));
            }
            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph.add(new Edge(from, to, -weight));
            }

            sb.append(isNegativeCycle() ? "YES" : "NO").append('\n');
            graph.clear();
        }

        System.out.println(sb);
    }

    static boolean isNegativeCycle() {
        dist = new int[N + 1];
        Arrays.fill(dist, 1_000_000_000);
        dist[1] = 0;

        for(int i = 0; i < N; i++) {
            boolean isUpdate = false;
            
            for(Edge next : graph) {
                if(dist[next.to] > dist[next.from] + next.weight) {
                    dist[next.to] = dist[next.from] + next.weight;
                    isUpdate = true;
                    if(i == N - 1) return true;
                }
            }
            if(!isUpdate) return false;
        }

        return false;
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

}