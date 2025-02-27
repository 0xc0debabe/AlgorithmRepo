class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("  for the what 1what  "));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean spaceFlag = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (spaceFlag) {
                c = Character.toUpperCase(c);
                spaceFlag = false;
            } else {
                c = Character.toLowerCase(c);
            }

            if (c == ' ') spaceFlag = true;
            sb.append(c);
        }

        return sb.toString();
    }

}



