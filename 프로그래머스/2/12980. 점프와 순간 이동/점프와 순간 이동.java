class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }

    public int solution(int n) {
        int result = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                n--;
                result++;
            } else {
                n /= 2;
            }

        }

        return result;
    }

}



