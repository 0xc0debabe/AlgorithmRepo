class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1));
    }

    public int solution(int num) {
        if (num == 1) return 0;
        int answer = 0;
        long n = num;
        for (int i = 0; i < 500; i++) {
            System.out.println("[num]=" + n + "[i]=" + i);
            if (n == 1){
                answer = i;
                break;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }

        return answer == 0 ? -1 : answer;
    }

}
