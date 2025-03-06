class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int lastCovered = 0;  // 마지막으로 전파가 닿은 아파트 번호
        
        // stations 배열의 각 기지국을 순차적으로 확인
        for (int station : stations) {
            // 현재 기지국이 전파할 수 있는 범위
            int start = station - w;  // 시작 범위
            int end = station + w;    // 종료 범위
            
            // 전파가 닿지 않는 구간이 있는지 확인
            if (lastCovered < start) {
                // 전파가 닿지 않는 구간의 크기
                int uncoveredArea = start - lastCovered - 1;
                // uncoveredArea 크기만큼 최소한 몇 개의 기지국이 필요한지 계산
                answer += (uncoveredArea + (2 * w)) / (2 * w + 1);
            }
            
            // 마지막으로 전파가 닿은 아파트 번호 갱신
            lastCovered = end;
        }
        
        // 마지막 기지국 이후에 전파가 닿지 않는 구간이 있다면 그 구간에 기지국 설치
        if (lastCovered < n) {
            int uncoveredArea = n - lastCovered;
            answer += (uncoveredArea + (2 * w)) / (2 * w + 1);
        }
        
        return answer;
    }
}