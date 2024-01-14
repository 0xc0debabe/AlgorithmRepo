import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        while (deque.size() > 1) {
            deque.pop();
            if (deque.size() > 1) {
                deque.offer(deque.pop());
            }
        }

        System.out.println(deque.pop());
    }
}
