package Bronze.II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursionist {
    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            sb.append(isPalidrome(s)).append(" ").append(index).append("\n");
            index = 0;
        }
        System.out.println(sb);
    }

    static int isPalidrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
    static int recursion(String s, int l, int r) {
        index++;
        if (l >= r) {
            return 1;
        }
        else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        else return recursion(s, l + 1, r - 1);
    }
}