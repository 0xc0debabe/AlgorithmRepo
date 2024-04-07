import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            sb = new StringBuilder();
            int pow = (int) Math.pow(3, n);
            for (int j = 0; j < pow; j++) {
                sb.append("-");
            }
            solution(0, pow);
            System.out.println(sb);
        }
    }

    public static void solution(int start, int size) {
        if (size == 1) {
            return;
        }

        int newSize = size / 3;
        for (int i = start + newSize; i < start + newSize * 2; i++) {
            sb.setCharAt(i, ' ');
        }

        solution(start, newSize);
        solution(start + 2 * newSize, newSize);
    }
}
