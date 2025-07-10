import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String standard = "";
        int answer = 0;
        int[] standardCount = new int[26];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                standard = br.readLine();
                for (int j = 0; j < standard.length(); j++) standardCount[standard.charAt(j) - 'A']++;
                continue;
            }

            String target = br.readLine();
            int[] targetCount = new int[26];
            for (int j = 0; j < target.length(); j++) targetCount[target.charAt(j) - 'A']++;

            for (int j = 0; j < 26; j++) targetCount[j] -= standardCount[j];

            boolean flag = true;
            int c1 = 0;
            int c2 = 0;
            for (int j = 0; j < 26; j++) {
                if (targetCount[j] >= 2 || targetCount[j] <= -2) {
                    flag = false;
                    break;
                }
                if (targetCount[j] > 0) c1++;
                else if (targetCount[j] < 0) c2++;
                if (c1 > 1 || c2 > 1) {
                    flag = false;
                    break;
                }
            }

            if (flag) answer++;
        }

        System.out.println(answer);
    }

}