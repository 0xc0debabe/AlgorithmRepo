public class Solution {
    public String solution(String s, String skip, int index) {
        // skip에 포함된 알파벳을 기록
        boolean[] isSkipped = new boolean[26];
        for (char ch : skip.toCharArray()) {
            isSkipped[ch - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int steps = index; // 이동해야 할 알파벳 수
            char current = ch;

            while (steps > 0) {
                current = (char) ((current - 'a' + 1) % 26 + 'a'); // 다음 알파벳으로 이동
                if (!isSkipped[current - 'a']) { // skip에 포함되지 않으면 steps 감소
                    steps--;
                }
            }

            result.append(current); // 결과에 변환된 문자 추가
        }

        return result.toString();
    }
}