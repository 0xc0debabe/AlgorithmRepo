
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 3};
        Solution s = new Solution();
        s.solution(a);
    }
    public int[] solution(int[] prices) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            while (!pq.isEmpty() && pq.peek().price > price) {
                Node poll = pq.poll();
                answer[poll.idx] = i - poll.idx;
            }

            pq.add(new Node(i, price));
        }

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            answer[poll.idx] = prices.length - 1 - poll.idx;
        }

        return answer;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int price;

        public Node(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return o.price - this.price;
        }
    }


}
