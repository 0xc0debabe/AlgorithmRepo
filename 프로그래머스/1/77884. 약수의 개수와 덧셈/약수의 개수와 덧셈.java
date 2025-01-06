class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(13, 17);
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cnt = 0;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (j * j == i) {
                        cnt += 1;
                        continue;
                    }

                    cnt += 2;
                }
            }

            if (cnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }

        return answer;
    }

}
