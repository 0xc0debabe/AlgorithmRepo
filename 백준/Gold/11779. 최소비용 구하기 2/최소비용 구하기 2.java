import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<List<int[]>> graph = new ArrayList<>();
    static int start, end;
    static int[] dist;
    static int[] parent;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        parent = new int[N + 1];
        
        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        StringTokenizer st;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new int[]{to, weight});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dijkstra();
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while(end != start) {
            stack.add(end);
            end = parent[end];
        }
        stack.add(start);
        sb.append(stack.size()).append('\n');
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        System.out.print(sb);
    }
    
    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowVertex = now[0];
            
            if(nowVertex == end) break;
            
            for(int[] next : graph.get(nowVertex)) {
                int nextVertex = next[0];
                int nextWeight = next[1];
                if(dist[nextVertex] > dist[nowVertex] + nextWeight) {
                    dist[nextVertex] = dist[nowVertex] + nextWeight;
                    pq.add(new int[]{nextVertex, dist[nextVertex]});
                    parent[nextVertex] = nowVertex;
                }
            }
        }
    }
}