class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String name = "JAZ";
        System.out.println(s.solution(name)); // 기대 출력: 11
    }

    public int solution(String name) {
        int len = name.length();
        int move = len - 1; // 기본적으로 오른쪽으로만 이동하는 경우
        int answer = 0;

        for (int i = 0; i < len; i++) {
            // 현재 문자를 목표로 변경하는 조작 횟수 계산
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 다음 위치에서 연속된 'A'의 구간 확인
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 되돌아가는 경우와 직진하는 경우를 비교하여 최소 이동 계산
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }

        return answer + move;
    }
}