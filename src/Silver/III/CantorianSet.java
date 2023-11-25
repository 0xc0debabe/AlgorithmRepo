package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CantorianSet {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            int n = Integer.parseInt(s);
            sb = new StringBuilder();
            int pow = (int) Math.pow(3, n);
            for (int i = 0; i < pow; i++) {
                sb.append("-");
            }

            subStr(0, pow);
            System.out.println(sb);
        }
    }

    static void subStr(int start, int end) {
        if (end == 1) return;
        int size = end / 3;

        for (int i = start + size; i < start + 2 * size; i++) {
            sb.setCharAt(i, ' ');
        }
        subStr(start, size);
        subStr(start+2*size, size);
    }
}