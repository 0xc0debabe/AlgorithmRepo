import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = " ";
        int len = s.length();
        for(int i = 0; i < len; i++) {
            String sub1 = s.substring(0, Math.min(i + 1, len));
            String first = reverse(sub1);
            for(int j = i + 1; j < len - 1; j++) {
                String sub2 = s.substring(i + 1, Math.min(j + 1, len));
                String second = reverse(sub2);
                String sub3 = s.substring(j + 1, len);
                String third = reverse(sub3);

                String target = first + second + third;
                if(answer.equals(" ") || answer.compareTo(target) > 0) {
                    answer = target;
                }
            }
        }

        System.out.println(answer);
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}