import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] num = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution.solution(want, num, discount));
    }

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) map.put(want[i], number[i]);

        int left = 0;
        int right = 10;

        for (int i = 0; i < 10; i++) {
            String item = discount[i];

            if (map.containsKey(item)) {
                map.put(item, map.get(item) - 1);
            }
        }

        int answer = 0;
        if (isZero(map)) answer++;
        while (right < discount.length) {
            String item1 = discount[right];
            if (map.containsKey(item1)) {
                map.put(item1, map.get(item1) - 1);
            }

            String item2 = discount[left];
            if (map.containsKey(item2)) {
                map.put(item2, map.get(item2) + 1);
            }

            if (isZero(map)) answer++;

            right++;
            left++;
        }

        return answer;
    }

    private boolean isZero(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }

}