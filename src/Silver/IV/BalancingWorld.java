package Silver.IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancingWorld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String sentence = br.readLine();

            if (sentence.equals(".")) {
                break;
            }

            sb.append(check(sentence)).append("\n");
        }
        System.out.println(sb);
    }

    static String check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')')  {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else return "no";
    }
}
