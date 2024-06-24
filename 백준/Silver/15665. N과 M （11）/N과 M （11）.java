import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr, blank;
    static Set<List<Integer>> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        blank = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        solution(0);
        System.out.println(sb);
    }

    static void solution(int depth) {
        if (depth == m) {
            List<Integer> list = new ArrayList<>();

            for (int v : blank) {
                list.add(v);
            }
            if (set.add(list)) {
                for (int v : blank) {
                    sb.append(v).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            blank[depth] = arr[i];
            solution(depth + 1);
        }
    }
}