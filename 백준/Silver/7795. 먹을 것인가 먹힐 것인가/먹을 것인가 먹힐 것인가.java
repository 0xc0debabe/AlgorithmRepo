import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> pqA = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> pqB = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                pqA.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                pqB.add(Integer.parseInt(st.nextToken()));
            }

            int answer = 0;
            while (!pqA.isEmpty()) {
                int poll = pqA.poll();

                while (!pqB.isEmpty() && pqB.peek() >= poll) {
                    pqB.poll();
                }

                answer += pqB.size();
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
