

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ar = {2, 3, 6};
        sol.solution(8, 4, ar);
    }

    public int solution(int n, int m, int[] section) {
        boolean[] shouldPaint = new boolean[n + 1];
        Arrays.fill(shouldPaint, true);
        for (int sect : section) {
            shouldPaint[sect] = false;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!shouldPaint[i]) {
                for (int j = i; j < Math.min(i + m, n + 1); j++) {
                    shouldPaint[j] = true;
                }

                i += m - 1;
                answer++;
            }
        }

        return answer;
    }

}
