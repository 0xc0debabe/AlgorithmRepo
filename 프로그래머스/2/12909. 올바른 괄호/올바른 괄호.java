import java.util.*;


class Solution {
    public static void main(String[] args) {
        int n = 10;
        int[] a = {7};
    }


    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            } 
        }

        return stack.isEmpty();
    }

}