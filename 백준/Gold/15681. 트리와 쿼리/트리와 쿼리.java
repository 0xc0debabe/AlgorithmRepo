import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] count;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        count = new int[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        fillVertexCount(r);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(count[Integer.parseInt(br.readLine())]);
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void fillVertexCount(int parent) {
        count[parent]++;
        isVisited[parent] = true;
        for (int child : graph.get(parent)) {
            if (isVisited[child]) continue;

            fillVertexCount(child);
            count[parent] += count[child];
        }
    }

}
