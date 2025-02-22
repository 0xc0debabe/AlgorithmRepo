import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {95, 90, 99, 99, 80, 99};
        int[] sp = {1, 1, 1, 1, 1, 1};
    }

    public int[] solution(int[] prices) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            while (!pq.isEmpty() && pq.peek()[0] > price) {
                int[] poll = pq.poll();
                int idx = poll[1];
                answer[idx] = i - idx;
            }

            pq.add(new int[]{price, i});
        }

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int idx = poll[1];
            answer[idx] = prices.length - 1 - idx;
        }

        return answer;
    }

}

