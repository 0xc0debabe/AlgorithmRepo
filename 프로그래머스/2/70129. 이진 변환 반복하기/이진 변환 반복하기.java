class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("01110");
    }


    public int[] solution(String s) {
        int cycle = 0;
        int zeroCnt = 0;
        while (true) {

            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') cnt++;
            }

            cycle++;
            zeroCnt += cnt;
            s = Integer.toBinaryString(s.length() - cnt);

            if (s.equals("1")) break;
        }

        return new int[]{cycle, zeroCnt};
    }


}