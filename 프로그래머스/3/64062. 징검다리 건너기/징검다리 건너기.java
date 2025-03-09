class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000;  // stones의 최댓값
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                left = mid + 1;  // 더 많은 인원이 건널 수 있는지 확인
            } else {
                right = mid - 1; // 인원 수를 줄여야 함
            }
        }
        
        return right;
    }
    
    private boolean canCross(int[] stones, int k, int people) {
        int skip = 0;
        
        for (int stone : stones) {
            if (stone < people) { // 건널 수 없는 경우
                skip++;
                if (skip >= k) return false; // 연속된 0이 k 이상이면 실패
            } else {
                skip = 0; // 다시 건널 수 있음
            }
        }
        
        return true;
    }
}