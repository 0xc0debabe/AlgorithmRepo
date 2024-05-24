import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<List<Integer>> lists;
    static boolean[] isVisited;
    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];
        answer = new int[n + 1];

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists.get(a).add(b);
            lists.get(b).add(a);
        }

        dfs(1);
        IntStream.range(2, n + 1).forEach(x -> System.out.println(answer[x]));
    }

    static void dfs(int n) {
        isVisited[n] = true;

        for (int value : lists.get(n)) {
            if (!isVisited[value]) {
                answer[value] = n;
                dfs(value);
            }
        }

    }
}