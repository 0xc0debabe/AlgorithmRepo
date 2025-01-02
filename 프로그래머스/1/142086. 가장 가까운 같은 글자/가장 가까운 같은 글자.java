
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("banana");
    }

    public int[] solution(String s) {
        int[] recentIdx = new int[26];
        Arrays.fill(recentIdx, -1);

        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (recentIdx[c - 'a'] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - recentIdx[c - 'a'];
            }

            recentIdx[c - 'a'] = i;
        }

        return answer;
    }


}
