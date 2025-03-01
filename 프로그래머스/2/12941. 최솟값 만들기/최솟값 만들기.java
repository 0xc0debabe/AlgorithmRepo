import java.util.Arrays;


class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println(solution.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - i - 1];
        }

        return sum;
    }

}