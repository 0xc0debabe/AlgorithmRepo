import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Deque<Double> numStack = new ArrayDeque<>();
        double[] alphabetArr = new double[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '*') {
                Double num1 = numStack.pollFirst();
                Double num2 = numStack.pollFirst();
                numStack.addFirst(num2 * num1);
            } else if (c == '/') {
                Double num1 = numStack.pollFirst();
                Double num2 = numStack.pollFirst();
                numStack.addFirst(num2 / num1);
            } else if (c == '+') {
                Double num1 = numStack.pollFirst();
                Double num2 = numStack.pollFirst();
                numStack.addFirst(num2 + num1);
            } else if (c == '-') {
                Double num1 = numStack.pollFirst();
                Double num2 = numStack.pollFirst();
                numStack.addFirst(num2 - num1);
            } else {
                if (alphabetArr[c - 'A'] == 0) {
                    double num = Integer.parseInt(br.readLine());
                    alphabetArr[c - 'A'] = num;
                    numStack.addFirst(num);
                } else {
                    numStack.addFirst(alphabetArr[c - 'A']);
                }
            }
        }

        System.out.printf("%.2f", numStack.pop());

    }
}