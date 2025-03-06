import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};
        solution.solution(a, b);
    }

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int idx = B.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < B[idx]) {
                idx--;
                answer++;
            }
        }

        return answer;
    }

}