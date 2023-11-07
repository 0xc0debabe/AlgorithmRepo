package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BalloonPop {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<int[]> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        StringBuilder sb = new StringBuilder();
//        sb.append("1 ");
//        int change = arr[0];

        for (int i = 0; i < n; i++) {
            deque.add(new int[] {(i + 1 ), arr[i]});
        }

        boolean changed = false;
        int change = 0;
        while (!deque.isEmpty()) {
            int peek = deque.peek()[0];
            int peek1 = deque.peek()[1];
            if (peek1 > 0) {
                sb.append(peek).append(" ");
                change = deque.poll()[1];
            } else {
                List<int[]> tempList = new LinkedList<>();
                while (!deque.isEmpty()) {
                    tempList.add(deque.pollLast());
                }

                for (int[] element : tempList) {
                    deque.add(element);
                }
                int peek3 = deque.peekLast()[0];
                sb.append(peek3).append(" ");
                change = deque.pollLast()[1];
                changed = true;
            }
            if (change > 0) {
                for (int i = 0; i < change - 1; i++) {
                    deque.add(deque.poll()); //pop : LIFO poll : FIFO
                }
            }
            else {
                for (int i = 0; i < change * -1 - 1; i++) {
                    deque.add(deque.poll());
//                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}