import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (s.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (s.equals("pop_front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollFirst());
            } else if (s.equals("pop_back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.pollLast());
            } else if (s.equals("size")) {
                System.out.println(deque.size());
            } else if (s.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);
            } else if (s.equals("front")) {
                System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
            } else if (s.equals("back")) {
                System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
            }
        }
    }
}