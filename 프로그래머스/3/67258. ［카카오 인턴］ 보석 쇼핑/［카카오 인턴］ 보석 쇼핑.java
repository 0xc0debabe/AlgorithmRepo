import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] s = {"A", "B", "B", "B", "C", "D", "D", "D", "D", "D", "D", "D", "B", "C", "A"};
        int[] solution1 = solution.solution(s);
        for (int i : solution1) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        for(String gem : gems) map.put(gem, map.getOrDefault(gem, 0) + 1);

        Map<String, Integer> myMap = new HashMap<>();
        int left = 0;
        int right = 0;
        List<int[]> list = new ArrayList<>();

        while (right <= gems.length && left <= right) {
            if (myMap.size() < map.size()) {
                if (right >= gems.length) break;

                myMap.put(gems[right], myMap.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (myMap.size() == map.size()) {
                list.add(new int[]{left + 1, right, right - left});

                int rest = myMap.get(gems[left]);
                if (rest == 1) {
                    myMap.remove(gems[left]);
                } else {
                    myMap.put(gems[left], rest - 1);
                }

                left++;
            }
        }

        list.sort((x, y) -> {
            if (x[2] == y[2]) {
                return x[0] - y[0];
            }
            return x[2] - y[2];
        });
        int[] answer = list.get(0);
        return new int[]{answer[0], answer[1]};
    }


}