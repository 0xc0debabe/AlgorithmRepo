import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int max = 0;

        char[][] ch = new char[5][15];
        for (int i = 0; i < ch.length; i++) {
            String s = br.readLine();
            if (s.length() > max){
                max = s.length();
            }
            for (int j = 0; j < s.length(); j++) {
                ch[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < ch.length; j++) {
                if (ch[j][i] != 0 || (int)(ch[j][i]) == 48) {
                    sb.append(ch[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}