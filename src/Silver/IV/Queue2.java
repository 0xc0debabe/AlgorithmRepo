package Silver.IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Queue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        while (n-- > 0) {
            stk = new StringTokenizer(br.readLine(), " ");

            switch (stk.nextToken()) {
                case "push" :
                    q.offer(Integer.parseInt(stk.nextToken()));
                    break;
                case "pop" :
                    Integer item = q.poll();
                    if (item == null) {
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(item).append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if(q.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    Integer ite = q.peek();
                    if(ite == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(ite).append('\n');
                    }
                    break;

                case "back":
                    Integer it = q.peekLast();
                    if(it == null) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(it).append('\n');
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}