import java.util.ArrayList;
import java.util.List;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15));
    }

    public int solution(int n) {
        int left = 1;
        int right = 1;
        int sum = 1;
        int answer = 0;

        while (left <= n && left <= right) {
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                answer++;
                sum -= left;
                left++;
            }
        }

        return answer;
    }

}