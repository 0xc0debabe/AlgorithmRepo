import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(10);
    }

    public int solution(int n) {
        int range = 1_000_001;
        boolean[] isPrime = new boolean[range];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(range); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < range; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return (int) IntStream.range(2, n + 1).filter(i -> isPrime[i]).count();
    }
}
