class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 1, 4};
        System.out.println(solution.solution(arr));
    }

    public int solution(int[] sticker) {
        if (sticker.length == 1) {
            return sticker[0];
        } else if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        } else if (sticker.length == 3) {
            return Math.max(Math.max(sticker[0], sticker[1]), sticker[2]);
        }

        int[] dp = new int[sticker.length];
        dp[1] = sticker[0];
        dp[2] = sticker[1];

        int answer = 0;
        int max = 0;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + sticker[i - 1];
            max = Math.max(dp[i], max);
        }

        answer = max;
        max = 0;
        dp = new int[sticker.length + 1];

        dp[1] = sticker[1];
        dp[2] = sticker[2];
        for (int i = 3; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + sticker[i];
            max = Math.max(dp[i], max);
        }

        answer = Math.max(answer, max);
        return answer;
    }


}