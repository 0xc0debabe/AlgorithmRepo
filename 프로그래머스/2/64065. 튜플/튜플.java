
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        sol.solution(s);
    }

    public int[] solution(String s) {
        s = s.substring(1);
        s = s.substring(0, s.length() - 1);

        boolean flag = false;
        List<List<Integer>> list = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{') {
                list.add(new ArrayList<>());
                flag = true;
            } else if (c == '}') {
                idx++;
                flag = false;
            }

            if (flag && Character.isDigit(c)) {
                int tmp = i;
                List<Integer> l = list.get(idx);
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(c)) {
                    sb.append(c);
                    c = s.charAt(++tmp);
                }
                l.add(Integer.parseInt(sb.toString()));
                i = tmp - 1;
            }

        }

        list.sort((x, y) -> x.size() - y.size());
        int[] answer = new int[list.size()];
        idx = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for (List<Integer> l : list) {
            for (int v : l) {
                if (!map.containsKey(v)) {
                    map.put(v, true);
                    answer[idx++] = v;
                }
            }
        }

        return answer;
    }


}