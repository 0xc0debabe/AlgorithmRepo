import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        String[] split = s.split("");

        for (String check : split) {
            map.put(check, map.getOrDefault(check, 0) + 1);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()){
            if (item.getValue() == 1) {
                list.add(item.getKey());
            }
        }

        Collections.sort(list);
        for (String a : list) {
            answer += a;
        }
        return answer;
    }
}