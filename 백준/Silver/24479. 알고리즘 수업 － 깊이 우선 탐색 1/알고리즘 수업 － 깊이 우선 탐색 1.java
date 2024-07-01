import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int n, m, r;
    static List<List<Integer>> list;
    static boolean[] isVisited;
    static int[] answer;
    static int cnt = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        answer = new int[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            list.get(end).add(start);
        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        if (!isVisited[start]) {
            isVisited[start] = true;
            answer[start] = cnt++;
            for (int v : list.get(start)) {
                dfs(v);
            }
        }
    }
}
