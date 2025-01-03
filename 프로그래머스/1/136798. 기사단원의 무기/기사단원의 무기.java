class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(5, 3, 2);
    }

    public int solution(int number, int limit, int power) {
        int[] divisor = new int[number + 1];

        for (int i = 1; i <= number; i++) {

            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    if (i == j * j){
                        divisor[i] += 1;
                        continue;
                    }

                    divisor[i] += 2;
                }
            }

        }

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (divisor[i] > limit) {
                answer += power;
                continue;
            }

            answer += divisor[i];
        }

        return answer;
    }


}
