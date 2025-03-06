import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2, 1);
    }

    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        int idx = 0;
        while (s > 0) {
            int divide = s / n;
            answer[idx++] = divide;
            s -= divide;
            n--;
        }

        return answer;
    }

}