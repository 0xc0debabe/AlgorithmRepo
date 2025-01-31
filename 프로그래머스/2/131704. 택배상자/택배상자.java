import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {3, 2, 1, 4, 5};
        System.out.println(sol.solution(a));
    }

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int baggage = 0;
        int idx = 0;
        int answer = 0;
        while (baggage++ < order.length) {
            if (order[idx] == baggage) {
                answer++;
                idx++;
            } else if (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
                baggage--;
            } else {
                stack.add(baggage);
            }
        }

        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            answer++;
            idx++;
        }

        return answer;
    }

}