class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int solution(int n) {
        int[] sum = new int[n + 1];
        sum[1] = 1;
        for (int i = 2; i <= n; i++) {
            sum[i] = (sum[i - 1] + sum[i - 2]) % 1234567;
        }

        return sum[n];
    }

}