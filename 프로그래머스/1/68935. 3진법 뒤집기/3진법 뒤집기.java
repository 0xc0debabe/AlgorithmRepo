class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(45);
    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        sb.reverse();
        int answer = 0;
        for (int i = 0; i < sb.length(); i++) {
            int num = sb.charAt(i) - '0';
            answer += (int) (Math.pow(3, i) * num);
        }

        return answer;
    }

}
