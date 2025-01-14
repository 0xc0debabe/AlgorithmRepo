import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 1};
        int[] times = {1, 2};
        System.out.println(sol.solution(arr, times, 100));
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 0;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;

            for (int i = 0; i < diffs.length; i++) {
                long diff = diffs[i];
                long time = times[i];
                if (diff <= mid) {
                    sum += time;
                } else {
                    long wrongCnt = diff - mid;
                    if (i == 0){
                        sum += time * wrongCnt + time;
                        continue;
                    }

                    sum += (times[i - 1] + time) * wrongCnt + time;
                }
            }

            if (sum <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer <= 0 ? 1 : answer;
    }
}
