import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        Stack<Integer>[] stacks = new Stack[]{stack1, stack2, stack3, stack4};

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int cnt = 0;
        boolean cant = false;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(stk.nextToken());

            for (int j = 0; j < 4; j++) {
                if (stacks[j].isEmpty()) {
                    stacks[j].add(m);
                    break;
                } else if (stacks[j].peek() < m) {
                    stacks[j].add(m);
                    break;
                } else {
                    cnt++;
                }
            }

            if (cnt == 4) {
                cant = true;
                break;
            } else {
                cnt = 0;
            }
        }
        System.out.println(cant ? "NO" : "YES");
    }
}