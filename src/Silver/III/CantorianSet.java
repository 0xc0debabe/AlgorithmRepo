package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CantorianSet {
    static char[] chars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s == null) {
                System.out.println(sb);
                break;
            }
            int n = Integer.parseInt(s);
            int cnt = (int)Math.pow(3, n);
            chars = new char[cnt];
            for (int i = 0; i < cnt; i++) {
                chars[i] = '-';
            }
            change(0, cnt);
            for (int i = 0; i < cnt; i++) {
                sb.append(chars[i]);
            }
            System.out.println(sb);

//            String s1 = new String(chars);
//            System.out.println(s1);
            sb.setLength(0);
        }
    }

    public static void change(int start, int size) {
        if (size < 3) {
            return;
        }
        for (int i = start + size / 3; i < start + size / 3 * 2; i++) {
            chars[i] = ' ';
        }
        change(start, size / 3);
        change(start + size / 3 * 2, size / 3);
    }
}