class Solution {
    public int solution(int n, long l, long r) {
        return countOnes(n, l - 1, r - 1); // 0-based indexing으로 변환
    }

    private int countOnes(int n, long l, long r) {
        if (n == 0) {
            // 0번째 비트열은 "1"만 있으므로, 범위에 포함되면 1, 아니면 0
            return 1;
        }

        long segmentSize = (long) Math.pow(5, n - 1); // 현재 비트열을 5등분한 각 조각의 크기
        int count = 0;

        for (int i = 0; i < 5; i++) {
            long start = i * segmentSize;
            long end = start + segmentSize - 1;

            if (l > end || r < start) {
                // 구간이 겹치지 않으면 건너뜀
                continue;
            }

            if (i == 2) {
                // 가운데 구간은 항상 "00000"이므로 1의 개수가 0
                continue;
            }

            // 겹치는 부분만 재귀적으로 탐색
            count += countOnes(n - 1, Math.max(l, start) - start, Math.min(r, end) - start);
        }

        return count;
    }
}