import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] info = {
                {1, 2},
                {2, 3},
                {2, 1}
        };
    }

    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = skill.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            map.put(c, i);
        }

        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            boolean[] isVisited = new boolean[skill.length()];
            String str = skill_trees[i];
            boolean flag = true;

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (map.containsKey(c)) {
                    int idx = map.get(c);

                    if (idx == 0) {
                        isVisited[idx] = true;
                        continue;
                    }

                    if (isVisited[idx - 1]) {
                        isVisited[idx] = true;
                    } else {
                        flag = false;
                        break;
                    }
                }

            }

            if (flag) answer++;
        }

        return answer;
    }
}

