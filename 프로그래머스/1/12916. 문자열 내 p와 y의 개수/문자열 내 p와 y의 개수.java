class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("Zbcdefg");
    }

    boolean solution(String s) {
        String target = s.toLowerCase();
        int p = 0;
        int y = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'p') {
                p++;
            } else if (target.charAt(i) == 'y') {
                y++;
            }
        }
        return p == y;
    }
}
