import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("1D2S0T"));
    }

    public int solution(String dartResult) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < dartResult.length(); i++) {
            boolean location = false;
            StringBuilder sb = new StringBuilder();
            int idx = i;

            while (true) {
                if (idx == dartResult.length()) {
                    i = idx - 1;
                    break;
                }

                char c = dartResult.charAt(idx);
                if ((c >= '0' && c <= '9' && location)) {
                    i = idx - 1;
                    break;
                } else if (c == 'S' || c == 'D' || c == 'T') {
                    sb.append('.');
                    location = true;
                } else if (c == '*' || c == '#') {
                    sb.append('.');
                }

                sb.append(c);
                idx++;
            }

            String[] split = sb.toString().split("\\.");
            int score = Integer.parseInt(split[0]);
            String bonus = split[1];
            if (bonus.equals("S")) {
                score = (int) Math.pow(score, 1);
            } else if (bonus.equals("D")) {
                score = (int) Math.pow(score, 2);
            } else {
                score = (int) Math.pow(score, 3);
            }
            if (split.length == 3) {
                String option = split[2];

                if (option.equals("*")) {
                    if (!stack.isEmpty()) {
                        stack.add(stack.pop() * 2);
                    }

                    score *= 2;
                } else {
                    score *= -1;
                }
            }

            stack.add(score);
        }

        int answer = 0;
        while (!stack.isEmpty()) answer += stack.pop();
        return answer;
    }

}
