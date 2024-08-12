import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Node> list;
    static int n, sx, sy, ex, ey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Node(x, y));
            }

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            if (bfs()) sb.append("happy").append('\n');
            else sb.append("sad").append('\n');
        }

        System.out.println(sb);
    }

    static boolean bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[n];
        queue.add(new Node(sx, sy));
        boolean flag = false;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            int arrive = Math.abs(now.x - ex) + Math.abs(now.y - ey);
            if (arrive <= 1000) {
                flag = true;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (isVisited[i]) continue;

                Node next = list.get(i);
                int dist = Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
                if (dist <= 1000) {
                    isVisited[i] = true;
                    queue.add(new Node(next.x, next.y));
                }
            }

        }

        return flag;
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
