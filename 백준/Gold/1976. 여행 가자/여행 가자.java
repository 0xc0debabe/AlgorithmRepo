import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static int[][] isVisited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        isVisited = new int[n + 1][n + 1];
        StringTokenizer stk;
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                isVisited[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] tripPlan = new int[m];
        String trip = br.readLine();
        String[] split = trip.split(" ");
        for (int i = 0; i < split.length; i++) {
            tripPlan[i] = Integer.parseInt(split[i]);
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isVisited[i][j] == 1) {
                    union(i, j);
                    isVisited[j][i] = 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean answer = false;
        for (int i = 0; i < m - 1; i++) {
            answer = false;
            answer = check(tripPlan[i], tripPlan[i + 1]);
            if (!answer) break;
        }

        sb.append(answer ? "YES" : "NO");
        System.out.println(sb);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean check(int a, int b) {
        return find(a) == find(b);
    }
}
