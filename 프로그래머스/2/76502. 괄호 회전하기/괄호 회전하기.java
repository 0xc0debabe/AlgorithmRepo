import java.util.EmptyStackException;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "[](){}";
        System.out.println(sol.solution(s));
    }

    public int solution(String s) {
        int len = s.length();
        int answer = 0;
        for (int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();

            boolean flag = true;
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);

                try {
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;

                    } else if (c == '}' && stack.peek() == '{') {
                        stack.pop();
                        continue;

                    } else if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                        continue;

                    }
                } catch (EmptyStackException e) {
                    flag = false;
                    break;
                }


                stack.add(c);
            }

            if (flag && stack.isEmpty()) answer++;
            String tmp = s;
            s = s.substring(1);
            s += tmp.charAt(0);
        }

        return answer;
    }


}