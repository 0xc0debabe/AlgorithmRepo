import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        int sum = Integer.parseInt(br.readLine());
        do {
            s = br.readLine();
            switch (s) {
                case "+":
                    sum += Integer.parseInt(br.readLine());
                    break;
                case "-":
                    sum -= Integer.parseInt(br.readLine());
                    break;
                case "*":
                    sum *= Integer.parseInt(br.readLine());
                    break;

                case "/":
                    sum /= Integer.parseInt(br.readLine());
                    break;

            }
        } while (!s.equals("="));
        System.out.println(sum);
    }
}