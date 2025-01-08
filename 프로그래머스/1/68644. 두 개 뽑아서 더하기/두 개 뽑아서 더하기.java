
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;

                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] array = set.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        return array;
    }

}
