class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] a = {"N~F=0", "R~T>2"};
        solution.solution(2, a);
    }

    String[] kf = {"A", "C", "F", "J", "M", "N", "R", "T"};
    boolean[] isVisited = new boolean[8];
    int answer = 0;
    public int solution(int n, String[] data) {
        dfs(n, data, 0, "");
        return answer;
    }

    private void dfs(int n, String[] data, int depth, String line) {
        if (depth == 8) {
            if (conditionCheck(n, data, line)) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(n, data, depth + 1, line + kf[i]);
                isVisited[i] = false;
            }
        }

    }

    private boolean conditionCheck(int n, String[] data, String line) {
        int f = 0;
        int t = 0;

        for (String d : data) {
            char from = d.charAt(0);
            char to = d.charAt(2);
            char sign = d.charAt(3);
            char dist = d.charAt(4);

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == from) {
                    f = i;
                } else if (line.charAt(i) == to) {
                    t = i;
                }
            }

            int abs = Math.abs(f - t) - 1;
            if (sign == '>' && abs <= dist - '0') return false;
            else if (sign == '<' && abs >= dist - '0') return false;
            else if (sign == '=' && abs != dist - '0') return false;
        }

        return true;
    }

}