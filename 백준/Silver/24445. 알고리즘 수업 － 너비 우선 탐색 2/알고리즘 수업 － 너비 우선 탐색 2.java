import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[] isVisited;
    static List<List<Integer>> list;
    static int[] answer;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.get(f).add(t);
            list.get(t).add(f);
        }

        for (int i = 1; i <= n; i++) {
            list.get(i).sort(Collections.reverseOrder());
        }

        bfs(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int cnt = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (!isVisited[poll]) {
                answer[poll] = cnt++;
                isVisited[poll] = true;
                for (int v : list.get(poll)) {
                    queue.add(v);
                }
            }
        }
    }
}
