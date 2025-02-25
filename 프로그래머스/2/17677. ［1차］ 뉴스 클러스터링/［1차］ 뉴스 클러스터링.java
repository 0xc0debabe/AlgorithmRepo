import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        System.out.println(solution.solution(str1, str2));
    }
    // aa aa aa // aa aa aa
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        findSet(map1, str1);
        findSet(map2, str2);

        double intersection = 0;
        double union = 0;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (map2.containsKey(key)) {
                intersection += Math.min(value, map2.get(key));
                union += Math.max(value, map2.get(key));
            } else {
                union += value;
            }
        }

        if (map1.isEmpty() && map2.isEmpty()) {
            return 65536;
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            if (!map1.containsKey(key)) {
                union += value;
            }
        }

        return (int) ((intersection / union) * 65536);
    }

    private void findSet(Map<String, Integer> map, String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (!Character.isAlphabetic(c)) continue;

            String str = "" + c;

            if (Character.isAlphabetic(s.charAt(i + 1))) {
                str += s.charAt(i + 1);
                str = str.toLowerCase();
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

        }
    }

}



