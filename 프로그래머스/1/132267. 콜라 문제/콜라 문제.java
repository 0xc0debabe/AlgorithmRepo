class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2, 1, 20)); // Expected: 19
        System.out.println(sol.solution(3, 1, 20)); // Expected: 9
    }

    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int share = n / a; // 교환한 콜라의 개수
            int remainder = n % a; // 교환 후 남은 빈 병
            answer += share * b; // 교환으로 받은 콜라 개수 누적
            n = share * b + remainder; // 새로 얻은 병과 나머지 병 합침
        }

        return answer;
    }
}