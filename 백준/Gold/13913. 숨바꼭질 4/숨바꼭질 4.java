import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dist = new int[100_001];
    static int[] find = new int[100_001];
    static boolean[] isVisited = new boolean[100_001];
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        sb.append(dist[k]).append("\n");
        tracking(k);
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        isVisited[n] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();


            if (poll - 1 >= 0 && !isVisited[poll - 1]) {
                isVisited[poll - 1] = true;
                dist[poll - 1] = dist[poll] + 1;
                find[poll - 1] = poll;
                queue.add(poll - 1);
            }

            if (poll * 2 < 100_001 && !isVisited[poll * 2]) {
                isVisited[poll * 2] = true;
                dist[poll * 2] = dist[poll] + 1;
                find[poll * 2] = poll;
                queue.add(poll * 2);
            }

            if (poll + 1 < 100_001 && !isVisited[poll + 1]) {
                isVisited[poll + 1] = true;
                dist[poll + 1] = dist[poll] + 1;
                find[poll + 1] = poll;
                queue.add(poll + 1);
            }

        }
    }

    static void tracking(int num) {
        while (num != n) {
            stack.add(num);
            num = find[num];
        }
        stack.add(num);
    }
}
