import java.io.*;
import java.util.*;

class Main {
    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        int[][] exam = new int[N][2];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            exam[i][0] = k;
            exam[i][1] = s;
        }

        //Arrays.sort(exam, (x, y) -> x[0] - y[0]);

        int[][] dp = new int[N + 1][T + 1];
        for(int i = 1; i <= N; i++) {
            int expectedStudyTime = exam[i - 1][0];

            for(int nowStudyTime = 1; nowStudyTime <= T; nowStudyTime++) {
                dp[i][nowStudyTime] = dp[i - 1][nowStudyTime];

                if(nowStudyTime >= expectedStudyTime){
                    dp[i][nowStudyTime] = Math.max(dp[i][nowStudyTime], dp[i - 1][nowStudyTime - expectedStudyTime] + exam[i - 1][1]);
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}