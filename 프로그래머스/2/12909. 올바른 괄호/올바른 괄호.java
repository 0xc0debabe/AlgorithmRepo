
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()(";
        solution.solution(s);
    }

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    continue;
                } else {
                    answer = false;
                    break;
                }
            }

            stack.add(c);
        }

        if (!stack.isEmpty()) answer = false;
        return answer;
    }

}