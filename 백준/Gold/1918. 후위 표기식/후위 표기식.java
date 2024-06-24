import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '*' || c == '/') {
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push('(');

            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop == '(') break;
                    sb.append(pop);
                }

            } else {
                sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }


        System.out.println(sb);
    }
}