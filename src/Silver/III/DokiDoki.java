package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class DokiDoki {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(stk.nextToken()));
        }

        int start = 1;
        while (!queue.isEmpty()) {
            if (start == queue.peek()) {
                start++;
                queue.poll();
            }
            else if (!stack.isEmpty() && stack.peek() == start) {
                start++;
                stack.pop();
            }
            else {
                stack.push(queue.poll());
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == start) {
                stack.pop();
                start++;
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}