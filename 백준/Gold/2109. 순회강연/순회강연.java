import java.io.*;
import java.util.*;

class Main {
    static class Lecture {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[n];
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(pay, day);
            maxDay = Math.max(maxDay, day);
        }

        // 마감일 기준 내림차순 정렬
        Arrays.sort(lectures, (a, b) -> b.day - a.day);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        int idx = 0;

        // 마지막 날부터 하루씩 거꾸로
        for (int day = maxDay; day >= 1; day--) {
            // 현재 day까지 가능한 강연을 모두 pq에 추가
            while (idx < n && lectures[idx].day >= day) {
                pq.add(lectures[idx].pay);
                idx++;
            }

            // pq에서 가장 큰 pay를 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}