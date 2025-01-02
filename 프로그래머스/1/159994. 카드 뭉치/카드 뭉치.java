

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ar = {2, 3, 6};
        String[] asd = {"ABACD", "BCEFD"};
        String[] aa = {"ABCD", "AABB"};
        sol.solution(asd, aa, asd);
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));

        for (String word : goal) {
            boolean flag = false;

            if (!q1.isEmpty() && q1.peek().equals(word)) {
                q1.poll();
                continue;
            }

            if (!q2.isEmpty() && q2.peek().equals(word)) {
                q2.poll();
                flag = true;
            }

            if (!flag) return "No";
        }
        return "Yes";
    }

}
