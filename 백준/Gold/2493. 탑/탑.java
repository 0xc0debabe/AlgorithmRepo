import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(new Node(Integer.parseInt(st.nextToken()), i));
        }
        Node pop1 = stack.pop();
        int prevIdx = pop1.idx;
        int prevHeight = pop1.height;
        int[] answer = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.height - y.height);
        pq.add(new Node(prevHeight, prevIdx));

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            int nowIdx = pop.idx;
            int nowHeight = pop.height;


            if (!pq.isEmpty() && pq.peek().height < nowHeight) {
                while (!pq.isEmpty() && pq.peek().height < nowHeight) {
                    Node poll = pq.poll();
                    answer[poll.idx] = nowIdx + 1;
                }
                pq.add(new Node(nowHeight, nowIdx));
            } else {
                pq.add(new Node(nowHeight, nowIdx));
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int v : answer) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}

class Node {
    int height;
    int idx;

    public Node(int height, int idx) {
        this.height = height;
        this.idx = idx;
    }
}