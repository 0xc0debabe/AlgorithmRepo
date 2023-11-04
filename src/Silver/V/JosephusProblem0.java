package Silver.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JosephusProblem0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            deque.offer(i + 1);
        }

        sb.append("<");
        while (deque.size() > 0) {
            for (int i = 0; i < k - 1; i++) {
                deque.offer(deque.pop());
            }
            sb.append(deque.pop()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb);
    }
}
