import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 4, 5, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.solution(4, a));
    }

    public int solution(int k, int[] tangerine) {
        int max = Arrays.stream(tangerine).max().getAsInt();
        int[] cnt = new int[max + 1];
        for (int t : tangerine) cnt[t]++;
        Arrays.sort(cnt);
        int sum = 0;
        int answer = 0;
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (sum >= k) break;
            sum += cnt[i];
            answer ++;
        }
        return answer;
    }



}