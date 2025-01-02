class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("3141592", "271"));
    }

    public int solution(String t, String p) {
        int len = t.length();
        int left = 0;
        int right = p.length();

        int answer = 0;
        while (right <= len) {
            String target = t.substring(left, right);

            if (isSmaller(target, p)) answer++;

            right++; left++;
        }

        return answer;
    }

    private boolean isSmaller(String target, String standard) {
        for (int i = 0; i < target.length(); i++) {
            char c1 = target.charAt(i);
            char c2 = standard.charAt(i);

            if (c1 > c2){
                return false;
            } else if (c1 < c2) {
                return true;
            }

        }

        return true;
    }


}
