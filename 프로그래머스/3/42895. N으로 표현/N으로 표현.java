import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;  // N을 한 번 사용해서 바로 목표를 만들 수 있는 경우

        // 숫자 사용 횟수별로 만들 수 있는 숫자 집합을 저장하는 배열
        Set<Integer>[] dp = new HashSet[9];

        // 초기화
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i))); // N, NN, NNN, ...
        }

        // 숫자 사용 횟수를 2부터 8까지 늘려가면서 숫자 조합을 계산
        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp[j]) {
                    for (int num2 : dp[i - j]) {
                        dp[i].add(num1 + num2);
                        dp[i].add(num1 - num2);
                        dp[i].add(num1 * num2);
                        if (num2 != 0) dp[i].add(num1 / num2);
                    }
                }
            }
            // 목표 숫자 발견 시 해당 사용 횟수 반환
            if (dp[i].contains(number)) return i;
        }

        // 8번 사용해도 목표 숫자를 만들 수 없는 경우 -1 반환
        return -1;
    }
}