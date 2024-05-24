import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static List<List<Integer>> lists;
    static boolean[] isVisited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        isVisited = new boolean[n];
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1){
                root = i;
                continue;
            }
            lists.get(i).add(x);
            lists.get(x).add(i);
        }
        int k = Integer.parseInt(br.readLine());

        if (k == root) {
            System.out.println(0);
        } else {
            dfs(root, k);
            System.out.println(answer);
        }


    }

    static void dfs(int n, int k) {
        isVisited[n] = true;
        int now = 0;

        for (int value : lists.get(n)) {
            if (!isVisited[value] && value != k) {
                now++;
                dfs(value, k);
            }
        }
        if (now == 0) {
            answer++;
        }
    }
}