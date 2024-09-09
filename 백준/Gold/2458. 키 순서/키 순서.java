import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = true;
        }

        for (int i = 1; i <= n; i++) {// 경유지
            for (int j = 1; j <= n; j++) {// 출발지
                for (int k = 1; k <= n; k++) { // 도착지
                    if (arr[j][i] && arr[i][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (arr[i][j]) cnt++;
            }

            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (arr[j][i]) cnt++;
            }

            if (cnt == n - 1) answer++;
        }

        System.out.println(answer);
    }
}
