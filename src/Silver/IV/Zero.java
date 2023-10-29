package Silver.IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            isZero(br.readLine());
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);
    }

    static void isZero(String zero) {
        if (!zero.equals("0")){
            stack.push(Integer.parseInt(zero));
        } else {
            stack.pop();
        }
    }
}
