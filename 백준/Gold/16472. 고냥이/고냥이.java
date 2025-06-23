import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] countAlphabet = new int[26];
        int pointer = 0;
        int continuousCount = 0;
        int answer = 0;
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (countAlphabet[c - 'a'] == 0) {
                continuousCount++;
            }
            countAlphabet[c - 'a']++;

            if (continuousCount > n) {
                while (true) {
                    char removedTarget = s.charAt(pointer++);
                    int remainNumber = --countAlphabet[removedTarget - 'a'];

                    if (remainNumber == 0) {
                        continuousCount--;
                        break;
                    }
                }
            }

            answer = Math.max(answer, i - pointer + 1);
        }

        System.out.println(answer);
    }

}