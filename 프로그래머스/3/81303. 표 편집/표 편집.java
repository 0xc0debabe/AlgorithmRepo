import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution.solution(8, 2, cmd));
    }

    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) prev[i] = i - 1;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) next[i] = i + 1;
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        int nowIdx = k;
        Stack<int[]> stack = new Stack<>();
        for (String command : cmd) {
            String[] split = command.split(" ");

            if (split[0].equals("U")) {
                int num = Integer.parseInt(split[1]);
                for (int i = 0; i < num; i++) {
                    nowIdx = prev[nowIdx];
                }

            } else if (split[0].equals("D")) {
                int num = Integer.parseInt(split[1]);
                for (int i = 0; i < num; i++) {
                    nowIdx = next[nowIdx];
                }

            } else if (split[0].equals("C")) {
                stack.add(new int[]{prev[nowIdx], next[nowIdx], nowIdx});
                if (prev[nowIdx] != -1) next[prev[nowIdx]] = next[nowIdx];
                if (next[nowIdx] != n) prev[next[nowIdx]] = prev[nowIdx];

                answer[nowIdx] = 'X';

                if (next[nowIdx] == n) {
                    nowIdx = prev[nowIdx];
                    continue;
                }
                nowIdx = next[nowIdx];

            } else if (split[0].equals("Z")){
                int[] commandInfo = stack.pop();
                int prevIdx = commandInfo[0];
                int nextIdx = commandInfo[1];
                int nowPos = commandInfo[2];
                answer[nowPos] = 'O';

                if (nextIdx != n) prev[nextIdx] = nowPos;
                if (prevIdx != -1) next[prevIdx] = nowPos;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : answer) sb.append(c);
        return sb.toString();
    }


}