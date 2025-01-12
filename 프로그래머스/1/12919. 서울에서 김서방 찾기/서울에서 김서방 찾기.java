class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
    }

    public String solution(String[] seoul) {
        int idx = 0;
        for (int i = 0; i < seoul.length; i++) {
            String s = seoul[i];
            if (s.equals("Kim")) {
                idx = i;
                break;
            }
        }

        return "김서방은 " + idx + "에 있다";
    }
}
