import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int index;
    int num;

    public Node(int index, int num) {
        this.index = index;
        this.num = num;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(stk.nextToken());

            while (!deque.isEmpty() && deque.getLast().num > now) {
                deque.removeLast();
            }

            deque.addLast(new Node(i, now));

            if (deque.getFirst().index <= i - L) {
                deque.removeFirst();
            }
            sb.append(deque.getFirst().num).append(" ");
        }

        System.out.println(sb);
    }
}
