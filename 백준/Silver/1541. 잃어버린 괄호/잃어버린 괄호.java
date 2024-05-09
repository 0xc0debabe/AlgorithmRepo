import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 0;
        int tmp = 0;
        String[] split = s.split("-");
        if (split.length > 1) {
            String[] split1 = split[0].split("[+]");
            for (int i = 0; i < split1.length; i++) {
                answer += Integer.parseInt(split1[i]);
            }

            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].split("[+]");
                for (int j = 0; j < split2.length; j++) {
                    tmp += Integer.parseInt(split2[j]);
                }
            }

        } else {
            String[] onlyPlus = s.split("[+]");
            for (int i = 0; i < onlyPlus.length; i++) {
                answer += Integer.parseInt(onlyPlus[i]);
            }
        }


        System.out.println(answer - tmp);

    }
}