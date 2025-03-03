class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(50000000));
    }

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int[] numbers = {4, 1, 2};
        while (n > 0) {
            int remainder = n % 3;
            n = (n - 1) / 3;

            answer.insert(0, numbers[remainder]);
        }

        return answer.toString();
    }

}