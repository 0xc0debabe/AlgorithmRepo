import java.util.Stack;

public class Solution {
    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int j = 0; j < s.length; j++) {
            String number = s[j];
            int cnt = 0;

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < number.length(); i++) {
                char num = number.charAt(i);
                stack.push(num);

                if (stack.size() >= 3) {
                    if (
                            stack.get(stack.size() - 1) == '0' &&
                            stack.get(stack.size() - 2) == '1' &&
                            stack.get(stack.size() - 3) == '1'
                    ) {
                        stack.pop();
                        stack.pop();
                        stack.pop();
                        cnt++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            int idx = stack.size();
            boolean flag = false;

            while (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '0') flag = true;
                sb.insert(0, c);
                if (!flag) idx--;
            }

            for (int i = 0; i < cnt; i++) sb.insert(idx, "110");
            answer[j] = sb.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] s = {"1110", "100111100", "0111111010"};

        String[] answer = solution(s);
        for (String string : answer) {
            System.out.println(string);
        }
    }
}