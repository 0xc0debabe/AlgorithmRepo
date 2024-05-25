import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> lists;
    static boolean[] isVisited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        isVisited = new boolean[n];
        int root = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) {
                root = i;
                continue;
            }
            lists.get(i).add(num);
            lists.get(num).add(i);
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
        int cnt = 0;

        for (int value : lists.get(n)) {
            if (!isVisited[value] && value != k) {
                cnt++;
                dfs(value, k);
            }
        }

        if (cnt == 0) {
            answer++;
        }
    }
}