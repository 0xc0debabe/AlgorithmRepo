import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] dp = new int[target + 1];
        int[] singleOrBull = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= target; i++) {
            for(int j = 1; j <= 20; j++) {
                
                // 1. Single
                if(i - j >= 0) {
                    int curr = i;
                    int prev = i - j;
                    update(curr, prev, dp, singleOrBull, true);
                }
                
                // 2. Double
                if(i - 2 * j >= 0) {
                    int curr = i;
                    int prev = i - j * 2;
                    update(curr, prev, dp, singleOrBull, false);
                }
                
                // 3. Triple
                if(i - 3 * j >= 0) {
                    int curr = i;
                    int prev = i - j * 3;
                    update(curr, prev, dp, singleOrBull, false);
                }
                
            }
            
            if(i - 50 >= 0) {
                int curr = i;
                int prev = i - 50;
                update(curr, prev, dp, singleOrBull, true);
            }
        }
        
        return new int[]{dp[target], singleOrBull[target]};
    }
    
    private void update(int curr, int prev, int[] dp, int[] singleOrBull, boolean isSingleOrBull) {
        int newSingleOrDartCount = singleOrBull[prev] + (isSingleOrBull ? 1 : 0);
        if(dp[curr] > dp[prev] + 1) {
            dp[curr] = dp[prev] + 1;
            singleOrBull[curr] = newSingleOrDartCount;
        } else if(dp[curr] == dp[prev] + 1 && singleOrBull[curr] < newSingleOrDartCount) {
           singleOrBull[curr] = newSingleOrDartCount;
        }
    }
    
}