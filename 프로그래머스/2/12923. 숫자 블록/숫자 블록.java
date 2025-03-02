class Solution {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] answer = new int[size];

        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = getMaxBlock(i);
        }

        return answer;
    }

    // 주어진 숫자 n의 블록 값을 계산
    private int getMaxBlock(long n) {
        if (n == 1) return 0; // 1번 위치에는 0이 깔린다.

        int maxDivisor = 1;
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {  // d가 n의 약수라면
                int pair = (int)(n / d); // 짝이 되는 큰 약수

                if (pair <= 10_000_000) return pair; // 10,000,000 이하인 약수 발견 시 바로 반환
                maxDivisor = Math.max(maxDivisor, d); // 10,000,000 초과라면 더 작은 d 사용
            }
        }
        return maxDivisor;
    }
}