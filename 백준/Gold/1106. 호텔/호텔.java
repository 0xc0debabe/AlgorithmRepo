
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt(); // 필요한 고객 수
        int N = sc.nextInt(); // 도시 수

        int[] cost = new int[N + 1];      // 비용
        int[] customer = new int[N + 1];  // 고객 수

        for (int i = 1; i <= N; i++) {
            cost[i] = sc.nextInt();
            customer[i] = sc.nextInt();
        }

        int MAX_CUSTOMER = C + 100; // 여유를 두고 잡음
        int[][] dp = new int[N + 1][MAX_CUSTOMER + 1];

        // 초기화: 첫 번째 행은 무한 비용 (0명 확보 외에는 불가능하므로)
        for (int j = 1; j <= MAX_CUSTOMER; j++) {
            dp[0][j] = Integer.MAX_VALUE / 2;
        }

        // DP 수행
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= MAX_CUSTOMER; j++) {
                // 이전 도시까지 고려한 최소 비용 유지
                dp[i][j] = dp[i - 1][j];

                // 현재 도시의 광고를 여러 번 써서 고객을 확보하는 경우 고려
                if (j >= customer[i]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - customer[i]] + cost[i]);
                }
            }
        }

        // 최소 비용 계산 (C 이상부터 가능한 값 중 최솟값)
        int answer = Integer.MAX_VALUE;
        for (int j = C; j <= MAX_CUSTOMER; j++) {
            answer = Math.min(answer, dp[N][j]);
        }

        System.out.println(answer);
    }
}
