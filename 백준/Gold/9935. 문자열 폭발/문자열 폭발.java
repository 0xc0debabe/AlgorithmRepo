import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String s = br.readLine();

        String bomb = br.readLine();


        int idx = 0;
        while (idx < s.length()) {
            Stack<Character> stack1 = new Stack<>();

            for (int i = bomb.length() - 1; i >= 0; i--) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == bomb.charAt(i)) {
                        stack1.add(stack.pop());
                    } else break;
                } else break;
            }

            if (stack1.size() == bomb.length()) {
                continue;
            } else if (!stack1.isEmpty()){
                while (!stack1.isEmpty()) {
                    stack.add(stack1.pop());
                }
            }



            stack.add(s.charAt(idx++));
        }

        Stack<Character> stack1 = new Stack<>();
        for (int i = bomb.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                if (stack.peek() == bomb.charAt(i)) {
                    stack1.add(stack.pop());
                } else break;
            } else break;
        }
        if (!stack1.isEmpty() && stack1.size() != bomb.length()) {
            while (!stack1.isEmpty()) {
                stack.add(stack1.pop());
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("ALURF");
        } else {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        sb.reverse();
        System.out.println(sb);
    }
}
