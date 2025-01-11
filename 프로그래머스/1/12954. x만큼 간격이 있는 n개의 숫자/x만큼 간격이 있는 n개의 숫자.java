import java.util.List;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long[] result = solution.solution(-4, 2);
        for (long num : result) {
            System.out.print(num + " ");
        }
    }

    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add((long) x * i); // x * 1, x * 2, ..., x * n 계산
        }
        
        return list.stream().mapToLong(i -> i).toArray();
    }
}