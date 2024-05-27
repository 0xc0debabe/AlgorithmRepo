import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] tree;
    static List<List<Integer>> lists;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];
        isVisited = new boolean[n + 1];
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        bfs(1);
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(find(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        isVisited[n] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int value : lists.get(now)) {
                if (!isVisited[value]) {
                    isVisited[value] = true;
                    tree[value] = now;
                    queue.add(value);
                }

            }
        }
    }

    static int find(int a, int b) {
        Set<Integer> ancestorsA = new HashSet<>();
        while (a != 0) {
            ancestorsA.add(a);
            a = tree[a];
        }
        while (!ancestorsA.contains(b)) {
            b = tree[b];
        }
        return b;
    }
}