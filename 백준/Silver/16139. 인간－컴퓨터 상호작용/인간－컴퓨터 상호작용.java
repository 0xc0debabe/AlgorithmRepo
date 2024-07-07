import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int[][] dp = new int[26][target.length() + 1];
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);

            for (int j = 1; j <= target.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (c == target.charAt(j - 1)) {
                    dp[i][j] += 1;
                }
            }
        }



        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = st.nextToken().charAt(0) - 'a';
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int answer = dp[c][e + 1] - dp[c][s];
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
