import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr, blank;
    static boolean[] isVisited;
    static int n, m;
    static Set<List<Integer>> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        isVisited = new boolean[n];
        blank = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (m == depth) {
            List<Integer> list = new ArrayList<>();
            for (int v : blank) {
                list.add(v);
            }
            boolean add = set.add(list);

            if (add) {
                for (int value : blank) {
                    sb.append(value).append(" ");
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                blank[depth] = arr[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
