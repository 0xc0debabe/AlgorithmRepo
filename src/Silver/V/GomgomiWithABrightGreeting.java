package Silver.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class GomgomiWithABrightGreeting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String nickname = br.readLine();

            if (nickname.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(nickname);
            }
        }
        cnt += set.size();
        System.out.println(cnt);
    }
}