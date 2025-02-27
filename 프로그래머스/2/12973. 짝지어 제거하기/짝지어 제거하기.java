import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("baabaa");
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.add(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

}



