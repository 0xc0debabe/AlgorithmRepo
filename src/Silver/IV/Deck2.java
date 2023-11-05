package Silver.IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Deck2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int y = 0;
        while (n-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());

            if (x == 1) {
                y = Integer.parseInt(stk.nextToken());
                deque.offerFirst(y);
            }
            else if (x == 2) {
                y = Integer.parseInt(stk.nextToken());
                deque.offerLast(y);
            }
            else if (x == 3) {
                if (!deque.isEmpty()) {
                    sb.append(deque.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            else if (x == 4) {
                if (!deque.isEmpty()) {
                    sb.append((deque.pollLast())).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            else if (x == 5) {
                sb.append(deque.size()).append("\n");
            }
            else if (x == 6) {
                if (deque.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
            else if (x == 7) {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
            else {
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}