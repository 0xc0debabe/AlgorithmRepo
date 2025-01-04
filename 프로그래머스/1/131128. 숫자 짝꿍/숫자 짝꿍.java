class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("12321", "42531");
    }

    public String solution(String X, String Y) {
        int[] numbers1 = new int[10]; int[] numbers2 = new int[10];
        for (int i = 0; i < X.length(); i++) numbers1[X.charAt(i) - '0']++;
        for (int i = 0; i < Y.length(); i++) numbers2[Y.charAt(i) - '0']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) if (numbers1[i] > 0 && numbers2[i] > 0) sb.append(String.valueOf(i).repeat(Math.max(0, Math.min(numbers1[i], numbers2[i]))));
        return sb.length() == 0 ? "-1" : sb.charAt(0) == '0' ? "0" : sb.toString();
    }


}
