
import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ABABABABABABABAB";
        int[] solution1 = solution.solution(s);
        for (int i : solution1) {
            System.out.println(i);
        }
    }

    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            map.put(String.valueOf(c), i + 1);
        }

        int idx = 27;
        String[] split = msg.split("");
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < split.length && flag; i++) {
            int tmp = i;
            String str = "";

            int prevValue = i;
            while (true) {
                if (split.length <= tmp) {
                    list.add(prevValue);
                    flag = false;
                    break;
                }
                str += split[tmp];

                if (!map.containsKey(str)) {
                    map.put(str, idx++);
                    list.add(prevValue);
                    i += str.length() - 2;
                    break;
                }

                prevValue = map.get(str);
                tmp++;
            }

        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}

