import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean check = false;
        int[] arr = new int[n];
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (arr[i] > tmp) {
                while (arr[i] > tmp) {
                    sb.append("+").append("\n");
                    deque.addLast(tmp);
                    tmp++;
                }
                sb.append("-").append("\n");
                deque.pollLast();
            } else if (arr[i] < tmp) {
                if (!deque.isEmpty()) {
                    while (!deque.isEmpty()) {
                        sb.append("-").append("\n");
                        int poll = deque.pollLast();
                        if (poll + 1 == arr[i]) {
                            break;
                        }
                    }
                } else {
                    System.out.println("NO");
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println(sb);
        }
    }
}
