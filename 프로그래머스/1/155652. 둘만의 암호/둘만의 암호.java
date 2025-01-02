
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ar = {2, 3, 6};
        String[] asd = {"ABACD", "BCEFD"};
        String[] aa = {"ABCD", "AABB"};
        System.out.println(sol.solution("aukks", "wbqd", 5));
    }

    public String solution(String s, String skip, int index) {
        boolean[] skipAlphabet = new boolean[26];
        for (char c : skip.toCharArray()) {
            if (!skipAlphabet[c - 'a']) {
                skipAlphabet[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char current : s.toCharArray()) {
            int step = index;

            while (step > 0) {
                current = (char) ((current - 'a' + 1) % 26 + 'a'); // 다음 알파벳으로 이동
                if (!skipAlphabet[current - 'a']) { // skip에 포함되지 않으면 steps 감소
                    step--;
                }
            }

            sb.append(current);
        }

        return sb.toString();
    }

}
