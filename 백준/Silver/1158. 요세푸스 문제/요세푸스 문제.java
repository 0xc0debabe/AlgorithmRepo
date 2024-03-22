
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            list.add(queue.poll());
        }

        String answer = list.toString();
        answer = answer.replace('[', '<');
        answer = answer.replace(']', '>');

        System.out.println(answer);

    }
}
