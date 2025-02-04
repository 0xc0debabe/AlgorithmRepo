    class Solution {
        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.solution(437674, 3));
        }

        public int solution(int n, int k) {
            String form = changeForm(n, k);
            String[] split = form.split("0");
            int result = 0;

            for (int i = 0; i < split.length; i++) {
                if (split[i].isEmpty()) continue;

                long target = Long.parseLong(split[i]);
                if (target == 1) continue;
                
                boolean flag = true;
                for (int j = 2; j <= Math.sqrt(target); j++) {
                    if (target % j == 0) {
                        flag = false;
                        break;
                    }
                }

                if (flag) result++;
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
