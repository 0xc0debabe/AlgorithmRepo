import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static boolean[] isVisited = new boolean[200_001];
    static int n, k;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int time = poll.time;
            int pos = poll.pos;

            if (pos == k) {
                answer = Math.min(answer, time);
            }

            if (pos >= 0 && pos <= 200_000 && !isVisited[pos]) {
                queue.add(new Node(pos * 2, time));
                queue.add(new Node(pos - 1, time + 1));
                queue.add(new Node(pos + 1, time + 1));
                isVisited[pos] = true;
            }
        }
    }
}

class Node{
    int pos;
    int time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}
