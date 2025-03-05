import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 3, 3};
        solution.solution(4, arr);
    }

    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int w : works) pq.add(w);

        while (!pq.isEmpty() && n > 0) {
            int poll = pq.poll();

            if (poll == 0) break;
            pq.add(poll - 1);
            n--;
        }

        long answer = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer += (long) poll * poll;
        }

        return answer;
    }

}