import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        int[][] arr = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            arr[0][i] = i;
            arr[1][i] = Integer.parseInt(br.readLine());
            lists.get(i).add(arr[1][i]);
        }

        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            isVisited[i] = true;
            dfs(i, i);
            isVisited[i] = false;
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int v : answer) {
            sb.append(v).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int start, int target) {
        for (int v : lists.get(start)) {
            if (!isVisited[v]) {
                isVisited[v] = true;
                dfs(v, target);
                isVisited[v] = false;
            } else if (v == target) {
                answer.add(v);
                return;
            }
        }
    }
}
