class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] seq1 = {-1, -2, -3, -4, -5};
        int[] seq2 = {1, 2, 3, 4, 5};
        int[] seq3 = {5, -1, 0, -2, 3, -4, 5};
        int[] seq4 = {-2, 3, -5, 1, 2, -1, 6, -1};
        int[] seq5 = {-1, -3, 4, -1, -2, 6, -1};
        System.out.print(solution.solution(seq1));
        System.out.println(solution.solution1(seq1));

        System.out.print(solution.solution(seq2));
        System.out.println(solution.solution1(seq2));

        System.out.print(solution.solution(seq3));
        System.out.println(solution.solution1(seq3));

        System.out.print(solution.solution(seq4));
        System.out.println(solution.solution1(seq4));

        System.out.print(solution.solution(seq5));
        System.out.println(solution.solution1(seq5));
    }

    public long solution(int[] sequence) {
        int n = sequence.length;
        long maxSum1 = Long.MIN_VALUE, maxSum2 = Long.MIN_VALUE;
        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < n; i++) {
            int pulse1 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            int pulse2 = (i % 2 == 0) ? -sequence[i] : sequence[i];

            sum1 = Math.max(pulse1, sum1 + pulse1);
            sum2 = Math.max(pulse2, sum2 + pulse2);

            maxSum1 = Math.max(maxSum1, sum1);
            maxSum2 = Math.max(maxSum2, sum2);
        }

        return Math.max(maxSum1, maxSum2);
    }

    public long solution1(int[] sequence) {
        int[] seq1 = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) seq1[i] = sequence[i] * -1;
            else seq1[i] = sequence[i];
        }

        int[] seq2 = new int[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 1) seq2[i] = sequence[i] * -1;
            else seq2[i] = sequence[i];
        }

        long answer = 0;
        long sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (seq1[i] >= 0) {
                sum += seq1[i];
            } else {
                if (sum != 0) {
                    answer = Math.max(answer, sum);
                    sum = 0;
                } else {
                    answer = Math.max(answer, seq1[i]);
                }
            }
        }

        answer = Math.max(answer, sum);
        sum = 0;
        for (int i = 0; i < sequence.length; i++) {
            if (seq2[i] >= 0) {
                sum += seq2[i];
            } else {
                if (sum != 0) {
                    answer = Math.max(answer, sum);
                    sum = 0;
                } else {
                    answer = Math.max(answer, seq2[i]);
                }
            }
        }
        answer = Math.max(answer, sum);

        return answer;
    }


}