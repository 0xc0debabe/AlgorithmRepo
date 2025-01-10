import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 2, 3, 4};
        sol.solution(arr);
    }

    public int solution(int[] nums) {
        boolean[] isPrime = new boolean[3_000];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                if (isPrime[nums[i] + nums[j] + nums[k]]) {
                       answer++;
                    }
                }
            }
        }

        return answer;
    }

}
