import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcdefghijklmn.p"));
    }

    public String solution(String new_id) {
        char[] charArray = new_id.toLowerCase().toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (
                    (charArray[i] < 'a' || charArray[i] > 'z') &&
                    (charArray[i] < '0' || charArray[i] > '9') &&
                    (charArray[i] != '-' && charArray[i] != '_' && charArray[i] != '.')
            ) continue;
            sb.append(charArray[i]);
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (!stack.isEmpty()) {
                if (sb.charAt(i) == '.' && stack.peek() == '.') {
                    stack.pop();
                }
            }

            stack.add(sb.charAt(i));
        }
        if (!stack.isEmpty() && stack.get(0) == '.') {
            stack.remove(0);
        }
        if (!stack.isEmpty() && stack.get(stack.size() - 1) == '.') {
            stack.remove(stack.size() - 1);
        }
        StringBuilder sb2 = new StringBuilder();

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb2.append(stack.pop());
            }
        } else {
            sb2.append('a');
        }


        sb2.reverse();
        StringBuilder answer = new StringBuilder(sb2);
        if (answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = new StringBuilder(answer.substring(0, 14));
            }
        }

        while (answer.length() < 3) {
            answer.append(answer.charAt(answer.length() - 1));
        }

        return answer.toString();
    }

}
