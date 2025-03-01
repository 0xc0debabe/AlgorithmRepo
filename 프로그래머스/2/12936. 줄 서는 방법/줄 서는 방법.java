import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] answer = new int[n];
        long fact = 1;
        for (int i = 2; i < n; i++) {
            fact *= i;
        }

        k--; // 인덱스 보정 (0-based index)
        
        for (int i = 0; i < n; i++) {
            int index = (int)(k / fact);
            answer[i] = numbers.get(index);
            numbers.remove(index);

            if (i < n - 1) {
                k %= fact;
                fact /= (n - 1 - i);
            }
        }

        return answer;
    }
}