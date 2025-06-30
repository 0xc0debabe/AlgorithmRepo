import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int tmp = n;
        long pow = 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while (tmp != 0) {
            int rest = tmp % 2;
            if (rest == 1) pq.add(pow);

            tmp /= 2;
            pow *= 2;
        }

        long answer = 0;
        while (pq.size() > k) {
            long first = pq.poll();
            long second = pq.poll();

            if (first != second) answer += second - first;
            pq.add(second * 2);
        }

        
        System.out.println(answer);
    }
}