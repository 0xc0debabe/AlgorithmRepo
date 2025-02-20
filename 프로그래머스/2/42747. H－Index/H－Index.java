import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int left = 0, right = citations.length;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2; // h 값 후보
            int count = 0;

            // mid번 이상 인용된 논문의 개수 찾기
            for (int citation : citations) {
                if (citation >= mid) count++;
            }

            // mid 이상의 논문이 mid편 이상이면 h 가능
            if (count >= mid) {
                answer = mid;
                left = mid + 1; // h를 더 키워볼 수 있음
            } else {
                right = mid - 1; // h를 줄여야 함
            }
        }
        return answer;
    }
}