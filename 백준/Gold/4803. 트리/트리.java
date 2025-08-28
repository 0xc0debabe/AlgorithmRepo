import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean[] isVisited = new boolean[n + 1];
            int answer = 0;
            for(int i = 1; i <= n; i++) {
                if(!isVisited[i] && isTree(graph, isVisited, i)) {
                    answer++;
                }
            }

            sb.append("Case ").append(idx++).append(": ");
            if(answer == 0) {
                sb.append("No trees.");
            } else if(answer == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of ").append(answer).append(" trees.");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean isTree(List<List<Integer>> graph, boolean[] isVisited, int start) {
        Queue<int[]> q = new LinkedList<>();
        isVisited[start] = true;
        q.add(new int[]{start, -1}); // (현재 노드, 부모)

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int parent = cur[1];

            for(int next : graph.get(now)) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    q.add(new int[]{next, now});
                } else if(next != parent) {
                    // 부모가 아닌데 이미 방문됨 → 사이클
                    return false;
                }
            }
        }
        return true;
    }
}