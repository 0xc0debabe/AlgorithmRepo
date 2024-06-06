import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(from, to, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.from > 100_000 || now.from < 0 || visit[now.from]) continue;

            if (now.from == now.to) {
                System.out.println(now.depth);
                break;
            }

            visit[now.from] = true;
            queue.add(new Node(now.from + 1, to, now.depth + 1));
            queue.add(new Node(now.from * 2, to,now.depth + 1));
            queue.add(new Node(now.from - 1, to,now.depth + 1));
        }
    }
}

class Node {
    int from;
    int to;
    int depth;

    public Node(int from, int to, int depth) {
        this.from = from;
        this.to = to;
        this.depth = depth;
    }
}