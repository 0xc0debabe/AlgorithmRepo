import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (s.equals("(") || s.equals("[")) {
                stack.add(s);
            } else if (s.equals(")") || s.equals("]")) {

                int sum = 0;
                boolean check = false;

                while (!stack.isEmpty()) {
                    String pop = stack.pop();

                    if (pop.equals("(")) {
                        check = true;
                        if (s.equals("]")) {
                            flag = true;
                        }
                        if (sum == 0) {
                            stack.add("2");
                        } else {
                            stack.add(String.valueOf(sum * 2));
                        }
                        break;
                    } else if (pop.equals("[")) {
                        check = true;
                        if (s.equals(")")) {
                            flag = true;
                        }
                        if (sum == 0) {
                            stack.add("3");
                        } else {
                            stack.add(String.valueOf(sum * 3));
                        }
                        break;
                    } else {
                        sum += Integer.parseInt(pop);
                    }

                }

                if (!check) {
                    flag = true;
                }
            }

            if (flag) break;
        }

        int answer = 0;
        if (!flag) {
            while (!stack.isEmpty()) {
                String pop = stack.pop();
                if (pop.equals("(") || pop.equals("[")) {
                    answer = 0;
                    break;
                }
                answer += Integer.parseInt(pop);
            }
        }

        System.out.println(answer);
    }
}