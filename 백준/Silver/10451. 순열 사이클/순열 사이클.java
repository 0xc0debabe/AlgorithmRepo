
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    static List<List<Integer>> list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            list = new ArrayList<>();
            isVisited = new boolean[n + 1];
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                list.get(j).add(num);
            }

            for (int j = 1; j <= n; j++) {
                if (!isVisited[j]) {
                    dfs(j);
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        if (isVisited[start]) {
            return;
        }

        isVisited[start] = true;
        dfs(list.get(start).get(0));
    }
}