import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int topFloor = Integer.parseInt(st.nextToken());
        int startFloor = Integer.parseInt(st.nextToken());
        int goalFloor = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[topFloor + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startFloor, 0));
        boolean check = false;
        if (down == 0 && startFloor > goalFloor || up == 0 && startFloor < goalFloor) {
            check = true;
        }
        int answer = -1;

        if (!check) {
            while (!queue.isEmpty()) {
                Node poll = queue.poll();

                if (poll.now < 1 || poll.now > topFloor || isVisited[poll.now]) {
                    continue;
                }
                isVisited[poll.now] = true;
                if (poll.now == goalFloor) {
                    answer = poll.depth;
                    break;
                }

                queue.add(new Node(poll.now + up, poll.depth + 1));
                queue.add(new Node(poll.now - down, poll.depth + 1));
            }
        }


        System.out.println(answer == -1 ? "use the stairs" : answer);
    }

}

class Node {
    int now;
    int depth;

    public Node(int now, int depth) {
        this.now = now;
        this.depth = depth;
    }
}
