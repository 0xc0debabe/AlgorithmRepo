class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4444444444L));  // 예시 테스트
    }

    public long solution(long n) {
        // Step 1: 각 숫자의 개수를 세기 위한 배열
        int[] count = new int[10];
        while (n > 0) {
            count[(int) (n % 10)]++;  // 숫자 추출 후 개수 증가
            n /= 10;  // 숫자 한 자리를 제거
        }

        // Step 2: 내림차순으로 숫자 조합하여 결과 계산
        long answer = 0;
        for (int i = 9; i >= 0; i--) {
            while (count[i] > 0) {
                answer = answer * 10 + i;  // 해당 숫자 붙이기
                count[i]--;  // 그 숫자의 개수 하나 감소
            }
        }

        return answer;  // 결과 반환
    }
}