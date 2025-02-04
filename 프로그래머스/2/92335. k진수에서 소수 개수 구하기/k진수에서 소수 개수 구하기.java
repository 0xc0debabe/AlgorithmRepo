    import java.util.Arrays;

    class Solution {
        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.solution(110011, 10));
        }

        public int solution(int n, int k) {
            int range = 1_000_001;
            boolean[] isPrime = new boolean[range];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for (int i = 0; i * i< range; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < range; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            String form = changeForm(n, k);
            String[] split = form.split("0");
            int result = 0;
            for (int i = 0; i < split.length; i++) {
                if (split[i].isEmpty()) continue;
                
                if (isPrime[Integer.parseInt(split[i])]) {
                    result++;
                }
            }

            return result;
        }

        private String changeForm(int n, int k) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                sb.append(n % k);
                n /= k;
            }

            return sb.reverse().toString();
        }

    }
