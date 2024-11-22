import java.util.*;

class Solution {
    public static void main(String[] args) {
        int n = 10;
        int[] a = {7};
        Solution s = new Solution();
        System.out.println(s.solution(n, a));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1; // 최소 시간은 1분부터 시작
        long right = (long) times[times.length - 1] * n; // 최대 시간은 최장 심사 시간 * n명
        long answer = right; // 초기값은 최댓값으로 설정

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long capacity = 0;
            for (int time : times) {
                capacity += mid / time; // 현재 시간(mid) 내에 처리할 수 있는 인원 계산
            }

            if (capacity >= n) { // 심사 가능한 인원이 n명을 만족하는 경우
                answer = mid; // 가능한 최소 시간 갱신
                right = mid - 1; // 더 작은 시간 탐색
            } else { // 심사 가능한 인원이 부족한 경우
                left = mid + 1; // 더 큰 시간 탐색
            }
        }

        return answer;
    }
}