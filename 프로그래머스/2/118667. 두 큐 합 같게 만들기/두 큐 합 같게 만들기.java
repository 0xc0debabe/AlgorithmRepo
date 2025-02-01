import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] q1 = {1, 1, 1, 1};
        int[] q2 = {1, 1, 7, 1};
        System.out.println(solution.solution(q1, q2));
    }

    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0;
        long q2Sum = 0;
        q1Sum += Arrays.stream(queue1).sum();
        q2Sum += Arrays.stream(queue2).sum();
        long sum = q1Sum + q2Sum;

        if (sum % 2 != 0) return -1;
        long mid = sum / 2;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int q : queue1) q1.add(q);
        for (int q : queue2) q2.add(q);

        int answer = 0;
        for (int i = 0; i < queue1.length * 3; i++) {

            if (!q1.isEmpty() && q1Sum > mid) {
                int poll = q1.poll();
                q2.add(poll);
                q1Sum -= poll;
                q2Sum += poll;
                answer++;
                } else if (!q2.isEmpty() && q1Sum < mid) {
                int poll = q2.poll();
                q1.add(poll);
                q2Sum -= poll;
                q1Sum += poll;
                answer++;
            }

            if (q1Sum == q2Sum) break;

        }

        return q1Sum == mid ? answer : -1;
    }

}