import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        
        for (int i = 0; i < len; i++) {
            char c = number.charAt(i);

            // 스택이 비어있지 않고, 제거할 수 있는 횟수가 남아 있으며, 현재 숫자가 스택의 top보다 크면 pop
            while (!stack.isEmpty() && k > 0 && stack.peek() < c) {
                stack.pop();
                k--;  // 하나 제거했으므로 k 감소
            }

            stack.push(c);
        }

        // k가 남아 있다면 뒤에서 k개 삭제 (예: "4321", k=2 -> 앞에서 줄일 수 없으므로 뒤에서 제거)
        while (k-- > 0) {
            stack.pop();
        }

        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char num : stack) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("4177252841", 4));  // 결과: "775841"
    }
}