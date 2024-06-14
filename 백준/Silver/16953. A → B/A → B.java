import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        bfs();

    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 1));
        boolean check = false;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.currNum == b){
                check = true;
                System.out.println(now.cnt);
                break;
            } else if (now.currNum > b) continue;

            queue.add(new Node(now.currNum * 2, now.cnt + 1));

            String s = now.currNum + "1";
            if (s.length() >= 10) continue;
            queue.add(new Node(Integer.parseInt(s), now.cnt + 1));
        }

        if (!check) System.out.println(-1);
    }
}

class Node {
    int currNum;
    int cnt;

    public Node(int currNum, int cnt) {
        this.currNum = currNum;
        this.cnt = cnt;
    }
}
