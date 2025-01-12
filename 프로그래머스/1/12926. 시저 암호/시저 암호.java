class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

    }

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                sb.append(' ');
                continue;
            }
            
            if (Character.isLowerCase(c)) {
                sb.append((char) ((c - 'a' + n) % 26 + 'a'));
            } else {
                sb.append((char) ((c - 'A' + n) % 26 + 'A'));
            }
        }
        return sb.toString();
    }
}
