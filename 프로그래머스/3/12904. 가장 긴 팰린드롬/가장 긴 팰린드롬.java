class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solution("aaaaa"));
//        System.out.println(solution.solution("abcdcba"));
//        System.out.println(solution.solution("abacde"));
        System.out.println(solution.solution("abba"));
    }

    public int solution(String s) {
        if (s.length() == 1) return 1;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int answer = 0;
        for (int i = 0; i < length; i++) {
            answer = Math.max(answer, findPalindrome(charArray, i));
        }

        return answer;
    }

    private int findPalindrome(char[] charArray, int idx) {
        int i = 1;
        int length = charArray.length;
        int ret = 0;
        while (true) {
            if (idx - i < 0 || idx + i - 1 >= length) {
                ret =  (i - 1) * 2;
                break;
            }

            if (charArray[idx - i] != charArray[idx + i - 1]){
                ret =  (i - 1) * 2;
                break;
            }

            i++;
        }

        i = 1;
        while (true) {
            if (idx - i < 0 || idx + i >= length) {
                ret = Math.max(ret, (i - 1) * 2 + 1);
                break;
            }
            if (charArray[idx - i] != charArray[idx + i]){
                ret = Math.max(ret, (i - 1) * 2 + 1);
                break;
            }
            i++;
        }

        return ret;
    }

}