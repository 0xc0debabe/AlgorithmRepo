import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String pipe = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        int result = 0;
        for(int i=0; i<pipe.length();i++) {
            if (pipe.charAt(i) == '(') {
                stack.addFirst('(');
            } else if (pipe.charAt(i) == ')') {
                stack.pollLast();
            }
            if (i > 0) {
                if (pipe.charAt(i - 1) == '(' && pipe.charAt(i) ==')') {
                    result += stack.size();
                } else if (pipe.charAt(i-1)==')' && pipe.charAt(i) ==')'){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

