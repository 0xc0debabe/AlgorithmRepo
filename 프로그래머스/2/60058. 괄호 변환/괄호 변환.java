import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()))((()";
        System.out.println(solution.solution(s));
    }

    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String p) {
        if (p.isEmpty()) return p;

        String answer = "";

        int cut = findCutPoint(p);

        String u = p.substring(0, cut);
        String v = p.substring(cut);

        if (correctStr(u)) {
            answer += u + dfs(v);
        } else {
            answer += inCorrectStr(u, v);
        }

        return answer;
    }

    private int findCutPoint(String p) {
        char[] charArray = p.toCharArray();
        Stack<Character> stack = new Stack<>();
        int tmp = -1;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (!stack.isEmpty() && stack.peek() != c) {
                stack.pop();

                if (stack.isEmpty()) {
                    tmp = i;
                    break;
                }

                continue;
            }

            stack.add(c);
        }

        return tmp + 1;
    }

    private boolean correctStr(String s) {
        char[] charArray = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (!stack.isEmpty() && c == ')') {
                stack.pop();
                continue;
            }

            stack.add(c);
        }

        return stack.isEmpty();
    }

    private String inCorrectStr(String u, String v) {
        String ret = "(";
        ret += dfs(v) + ")";
        u = u.substring(1, u.length() - 1);
        return ret + changeStr(u);
    }

    private String changeStr(String u) {
        StringBuilder sb = new StringBuilder();
        for (char c : u.toCharArray()) {
            if (c == '(') sb.append(')');
            else sb.append('(');
        }

        return sb.toString();
    }
}

