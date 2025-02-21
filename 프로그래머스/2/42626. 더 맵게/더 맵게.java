import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3};
        System.out.println(solution.solution(arr, 7));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.add(i);
        int answer = 0;

        while (pq.size() >= 2) {
            if (pq.peek() >= K) return answer;

            int first = pq.poll();
            int second = pq.poll();

            pq.add(first + second * 2);
            answer++;
        }

        if (!pq.isEmpty()) {
            if (pq.poll() >= K) return answer;
        }
        return -1;
    }

}

