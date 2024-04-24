import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] answerArr = new int[n];
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(stk.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
                answerArr[deque.pollLast()] = A[i];
            }
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            answerArr[deque.pollLast()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int value : answerArr) {
            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
