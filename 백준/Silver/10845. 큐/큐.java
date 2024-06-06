import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("push")) {
                queue.offer(Integer.parseInt(st.nextToken()));
            } else if (s.equals("pop")) {
                System.out.println(queue.isEmpty() ? -1 : queue.poll());
            } else if (s.equals("size")) {
                System.out.println(queue.size());
            } else if (s.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (s.equals("front")) {
                System.out.println(queue.isEmpty() ? -1 : queue.peekFirst());   
            } else {
                System.out.println(queue.isEmpty() ? -1 : queue.peekLast());
            }
        }
    }
}