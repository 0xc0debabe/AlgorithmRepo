import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>((x, y) -> Math.toIntExact(x - y));
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long answer = 0;
        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();
            answer +=  num1 +  num2;

            if (!pq.isEmpty()) {
                pq.add(num1 + num2);
            }
        }
        

        System.out.println(answer);
    }
}