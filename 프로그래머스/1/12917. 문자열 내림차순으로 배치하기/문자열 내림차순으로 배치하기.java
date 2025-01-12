class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("Zbcdefg");
    }

    public String solution(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            for (int j = 0; j < chars.length - i - 1; j++) {
                char c1 = chars[j];
                char c2 = chars[j + 1];
                if (c1 < c2){
                    chars[j + 1] = c1;
                    chars[j] = c2;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}
