import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] dist;
    static int[] find;
    static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        StringTokenizer st;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new int[]{to, weight});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');

        find[start] = -1;
        Stack<Integer> stack = new Stack<>();
        int tmp = end;
        while(tmp != start) {
            stack.add(tmp);
            tmp = find[tmp];
        }
        stack.add(start);
        sb.append(stack.size()).append('\n');
        while(!stack.isEmpty()) {
            int pop = stack.pop();
            sb.append(pop).append(' ');
        }
        System.out.println(sb);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        dist = new int[N + 1];
        find = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            int nowVertex = now[0];

            if(nowVertex == end) {
                break;
            }

            for(int[] next : graph.get(nowVertex)) {
                int nextVertex = next[0];
                int nextWeight = next[1];

                if(dist[nextVertex] > dist[nowVertex] + nextWeight) {
                    dist[nextVertex] = dist[nowVertex] + nextWeight;
                    find[nextVertex] = nowVertex;
                    pq.add(new int[]{nextVertex, dist[nextVertex]});
                }
            }
        }

    }
}