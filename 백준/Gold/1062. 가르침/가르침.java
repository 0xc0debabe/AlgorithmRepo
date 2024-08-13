import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, answer;
    static boolean[] isVisited = new boolean[26];
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = 0;

        isVisited['a' - 'a'] = true;
        isVisited['c' - 'a'] = true;
        isVisited['i' - 'a'] = true;
        isVisited['n' - 'a'] = true;
        isVisited['t' - 'a'] = true;

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            s = s.replace("anta", "");
            s = s.replace("tica", "");
            arr[i] = s;
        }

        if (k < 5) {
            System.out.println(answer);
        } else if (k == 26) {
            System.out.println(n);
        } else {
            dfs(0, 0);
            System.out.println(answer);
        }
    }

    static void dfs(int depth, int idx) {
        if (depth == k - 5) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                boolean flag = false;

                for (int j = 0; j < arr[i].length(); j++) {
                    if (!isVisited[arr[i].charAt(j) - 'a']) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(depth + 1, i + 1);
                isVisited[i] = false;
            }
        }

    }
}
