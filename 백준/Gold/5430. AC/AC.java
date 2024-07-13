import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String[] split = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            String s = br.readLine();
            s = s.substring(1, s.length() - 1);
            String[] tmp = s.split(",");
            for (int j = 0; j < n; j++) {
                deque.addFirst(Integer.parseInt(tmp[j]));
            }

            boolean check = false;
            boolean check1 = false;
            for (int j = 0; j < split.length; j++) {
                if (split[j].equals("R")) {
                    check = !check;
                } else {
                    if (!deque.isEmpty()) {
                        if (check) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    } else {
                        sb.append("error").append("\n");
                        check1 = true;
                        break;
                    }
                }
            }
            if (check1) continue;

            if (deque.isEmpty()) {
                sb.append("[]").append("\n");
            } else {

                sb.append("[");
                while (!deque.isEmpty()) {
                    if (check) {
                        sb.append(deque.pollFirst()).append(",");
                    } else {
                        sb.append(deque.pollLast()).append(",");
                    }
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append("]").append("\n");
            }
        }

        System.out.println(sb);
    }
}