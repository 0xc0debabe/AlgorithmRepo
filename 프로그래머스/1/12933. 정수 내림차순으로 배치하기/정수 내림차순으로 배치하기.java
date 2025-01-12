import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4444444444L));
    }

    public long solution(long n) {
        Map<Long, Integer> map = new HashMap<>();
        while (n > 0) {
            long l = n % 10;
            map.put(l, map.getOrDefault(l, 0) + 1);
            n /= 10;
        }

        long answer = 0;
        for (long i = 9; i >= 0; i--) {
            if (map.containsKey(i)) {
                int cnt = map.get(i);
                while (cnt > 0) {
                    answer += i;
                    answer *= 10;
                    cnt--;
                }
            }
        }

        return answer / 10;
    }
}
