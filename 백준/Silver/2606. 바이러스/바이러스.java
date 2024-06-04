import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isVisited = new boolean[n + 1];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lists.get(from).add(to);
            lists.get(to).add(from);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : lists.get(now)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (isVisited[i]) answer++;
        }
        System.out.println(answer - 1);
    }
}