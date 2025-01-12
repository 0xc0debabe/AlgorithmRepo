class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(118372));
    }

    public int[] solution(long n) {
        int[] answer = new int[String.valueOf(n).length()];
        
        int idx = 0;
        while (n > 0) {
            answer[idx++] = (int) (n % 10); 
            n /= 10;
        }

        return answer;
    }
}
