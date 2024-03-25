class Solution {
    public int solution(String s) {
       String[] strNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] intNum = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int answer = 0;

        int idx = 0;

        while (idx < 10) {
            s = s.replaceAll(strNum[idx], intNum[idx]);
            idx++;
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}