import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution.solution(arr));  // 2
    }

    public int solution(int[][] routes) {
        // 차량의 종료 지점 기준으로 정렬
        Arrays.sort(routes, (x, y) -> Integer.compare(x[1], y[1]));

        int answer = 0;
        int nowPos = -30_001; // 초기 카메라 위치는 가장 왼쪽보다 작은 값으로 설정

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            // 현재 카메라 위치가 이 차량의 진출 지점보다 뒤에 있으면 카메라 설치
            if (nowPos < start) {
                nowPos = end;  // 새로운 카메라를 이 차량의 종료 지점에 설치
                answer++;
            }
        }

        return answer;
    }
}