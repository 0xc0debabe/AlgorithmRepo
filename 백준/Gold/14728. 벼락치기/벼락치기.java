import java.io.*;
import java.util.*;

class Main {
    static int N, T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        int[] expStudyTime = new int[N];
        int[] scores = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            expStudyTime[i] = Integer.parseInt(st.nextToken());
            scores[i] = Integer.parseInt(st.nextToken());
        }
        
        int[][] dp = new int[N + 1][10_001];
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            int expected = expStudyTime[i - 1];
            int score = scores[i - 1];
            
            for(int studyTime = 1; studyTime <= 10_000; studyTime++) {
                dp[i][studyTime] = dp[i - 1][studyTime];
                
                if(studyTime >= expected) {
                    dp[i][studyTime] = Math.max(dp[i][studyTime], dp[i - 1][studyTime - expected] + score);
                }
                
            }
        }
        
        System.out.println(dp[N][T]);
    }
}