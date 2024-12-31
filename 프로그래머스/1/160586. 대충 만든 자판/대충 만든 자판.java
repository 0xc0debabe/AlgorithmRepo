
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ar = {2, 3, 6};
        String[] asd = {"ABACD", "BCEFD"};
        String[] aa = {"ABCD", "AABB"};
        sol.solution(asd, aa);
    }

    public int[] solution(String[] keymap, String[] targets) {
        char[][] charArr = new char[keymap.length][];

        for (int i = 0; i < keymap.length; i++) {
            charArr[i] = new char[keymap[i].length()];
            for (int j = 0; j < keymap[i].length(); j++) {
                charArr[i][j] = keymap[i].charAt(j);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (String target : targets) {
            int cnt = 0;
            boolean flag = true;

            for (int i = 0; i < target.length(); i++) {
                char t = target.charAt(i);
                int min = Integer.MAX_VALUE;

                for (int j = 0; j < charArr.length; j++) {
                    char[] chars = charArr[j];

                    for (int k = 0; k < chars.length; k++) {
                        if (chars[k] == t) {
                            min = Math.min(min, k);
                            break;
                        }
                    }
                }

                if (min == Integer.MAX_VALUE) {
                    list.add(-1);
                    flag = false;
                    break;
                }

                cnt += min + 1;
            }

            if (flag) {
                list.add(cnt);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
