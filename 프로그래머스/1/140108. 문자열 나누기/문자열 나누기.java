
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abracadabra"));
    }

    public int solution(String s) {
        int answer = 0;
        int firstNum = 0;
        int elseNum = 0;
        char firstChar = ' ';

        for (char c : s.toCharArray()) {
            if (firstChar == ' ') firstChar = c;

            if (firstChar == c) {
                firstNum++;
            } else {
                elseNum++;
            }

            if (firstNum == elseNum) {
                answer++;
                firstChar = ' ';
                firstNum = 0;
                elseNum = 0;
            }
        }

        return firstNum == elseNum ? answer : answer + 1;
    }


}
