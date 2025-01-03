
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(10, new int[]{1, 10, 2, 5, 6, 7, 8});
    }

    public int[] solution(int k, int[] scores) {
        int[] arr = new int[2001];

        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int score : scores) {
            pq.add(score);
            if (pq.size() > k) pq.poll();
            list.add(pq.peek());
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
