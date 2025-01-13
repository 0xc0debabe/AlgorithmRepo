class Solution {
    public static void main(String[] args) {
        String s = "ab";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 == 0) {
            sb.append(s.charAt(s.length() / 2 - 1));
        }
        sb.append(s.charAt(s.length() / 2));
        return sb.toString();
    }
}
