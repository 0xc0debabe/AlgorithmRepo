class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("aaa  "));
    }

    public String solution(String s) {
        String[] split = s.split("");
        StringBuilder sb = new StringBuilder();

        boolean isOdd = false;

        for (int i = 0; i < split.length; i++) {
            if (split[i].charAt(0) == ' ') {
                sb.append(' ');
                isOdd = false;
                continue;
            }

            if (!isOdd) {
                sb.append(Character.toUpperCase(split[i].charAt(0)));
                isOdd = true;
            } else {
                sb.append(Character.toLowerCase(split[i].charAt(0)));
                isOdd = false;
            }
        }

        return sb.toString();
    }
}
