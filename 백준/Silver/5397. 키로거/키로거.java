import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int j = 0; j < n; j++) {
            Deque<Character> answer = new ArrayDeque<>();
            Deque<Character> deque2 = new ArrayDeque<>();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '<') {
                    if (!answer.isEmpty()) {
                        deque2.addFirst(answer.pollFirst());
                    }
                } else if (c == '>') {
                    if (!deque2.isEmpty()) {
                        answer.addFirst(deque2.pollFirst());
                    }
                } else if (c == '-') {
                    if (!answer.isEmpty()) {
                        answer.pollFirst();
                    }
                } else {
                    answer.addFirst(c);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!answer.isEmpty()) {
                sb.append(answer.pollLast());
            }

            while (!deque2.isEmpty()) {
                sb.append(deque2.pollFirst());
            }

            System.out.println(sb);

        }

    }
}