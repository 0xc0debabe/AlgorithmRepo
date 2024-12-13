
import java.util.*;
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String h = "hit";
        String c = "cog";
        String[] ar = {"hot", "dot", "dog", "lot", "log", "cog"};
        sol.solution(h, c, ar);
    }

    boolean[] isVisited;
    int answer = 0;
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (isVisited[i]) continue;
            
            if (isSimilarWord(begin, words[i])) {
                isVisited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                isVisited[i] = false;
            }
        }

    }

    boolean isSimilarWord(String standard, String target) {
        int cnt = 0;
        for (int i = 0; i < standard.length(); i++) {
            if (standard.charAt(i) != target.charAt(i)) {
                cnt++;
            }

            if (cnt >= 2) {
                return false;
            }
        }

        return cnt == 1;
    }

}