import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        sol.solution(numbers);
    }

    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }
            stack.add(i);
        }

        return result;
    }

}