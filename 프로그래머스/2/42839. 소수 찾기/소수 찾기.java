import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("011");
    }

    boolean[] isVisited;
    boolean[] isPrime;
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        isVisited = new boolean[numbers.length()];
        int range = 10_000_000;
        isPrime = new boolean[range];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 0; i * i < range; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < range; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        findPermutation(numbers, "");
        return set.size();
    }

    private void findPermutation(String number, String str) {

        for (int i = 0; i < number.length(); i++) {
            if (!isVisited[i]) {
                char c = number.charAt(i);

                int target = Integer.parseInt(str + c);
                if (isPrime[target])set.add(target);

                isVisited[i] = true;
                findPermutation(number, str + c);
                isVisited[i] = false;
            }
        }
    }

}

