import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while (s.length() < t.length()) {
            if (t.charAt(t.length() - 1) == 'B'){
                t.deleteCharAt(t.length() - 1);
                t.reverse();
                continue;
            }

            t.deleteCharAt(t.length() - 1);
        }

        System.out.println(t.toString().equals(s.toString()) ? 1 : 0);
    }
}
