
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sorry = "I'm Sorry Hansoo";
        int[] alphabetCnt = new int[26];
        int[] alphabetCnt2 = new int[26];
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alphabetCnt[c - 'A']++;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabetCnt[i] % 2 == 1) {
                cnt++;
            }
        }

        boolean check = false;
        StringBuilder sb = new StringBuilder();
        if (cnt >= 2) {
            check = true;
        }
        if (check) {
            System.out.println(sorry);
        } else {
            for (int i = 0; i < 26; i++) {
                int tmp = 0;
                if (alphabetCnt[i] > 0) {
                    tmp = alphabetCnt[i] / 2;
                    alphabetCnt2[i] = alphabetCnt[i] % 2;
                    alphabetCnt[i] = tmp;
                    while (tmp-- > 0) {
                        sb.append((char) (i + 'A'));
                    }
                }
            }

            for (int i = 0; i < 26; i++) {
                if (alphabetCnt2[i] > 0) {
                    sb.append((char) (i + 'A'));
                }
            }

            for (int i = 25; i >= 0; i--) {
                int tmp = 0;
                if (alphabetCnt[i] > 0) {
                    tmp = alphabetCnt[i];
                    alphabetCnt[i] = tmp;
                }
                while (tmp-- > 0) {
                    sb.append((char) (i + 'A'));
                }
            }
        }
        System.out.println(sb);
    }
}