import java.util.*;

public class Main {
    static int[] days;
    static int N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 일 수
        M = sc.nextInt(); // 인출 횟수
        days = new int[N];

        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            days[i] = sc.nextInt();
            max = Math.max(max, days[i]);
            sum += days[i];
        }

        int left = max;     // 최소 인출 금액
        int right = sum;    // 최대 인출 금액
        int answer = sum;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canWithdraw(mid)) {
                answer = mid;
                right = mid - 1; // 더 줄여도 되는지 확인
            } else {
                left = mid + 1;  // 너무 작아서 못씀
            }
        }

        System.out.println(answer);
    }

    // mid원을 기준으로 인출 횟수가 M번 이하인지 확인
    static boolean canWithdraw(int k) {
        int count = 1; // 첫 번째 인출
        int balance = k;

        for (int money : days) {
            if (balance < money) {
                count++;
                balance = k;
            }
            balance -= money;
        }

        return count <= M;
    }
}