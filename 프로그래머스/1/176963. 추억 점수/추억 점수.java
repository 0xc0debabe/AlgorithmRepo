
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"mumu", "soe", "poe", "kai", "mine"};
        String[] a = {"kai", "kai", "mine", "mine"};

    }

    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < yearning.length; i++) {
            map.put(name[i], yearning[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (String[] photo : photos) {
            int miss = 0;
            for (String p : photo) {
                if (map.containsKey(p)) {
                    miss += map.get(p);
                }
            }
            list.add(miss);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
