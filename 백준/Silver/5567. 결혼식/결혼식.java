import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<List<Integer>> list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }
        dfs(1, 0);

        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isVisited[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void dfs(int start, int depth) {
        if (depth <= 2) {
            isVisited[start] = true;
            for (int v : list.get(start)) {
                dfs(v, depth + 1);
            }
        }
    }
}
