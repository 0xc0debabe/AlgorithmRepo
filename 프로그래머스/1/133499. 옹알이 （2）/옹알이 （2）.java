import java.util.Map;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] as = {"ayayeayayeaya"};
        System.out.println(sol.solution(as));
    }

    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};

        int answer = 0;
        for (String babb : babbling) {
            String prev = "";

            while (true) {
                int length = babb.length();

                if (length == 0) {
                    answer++;
                    break;
                }

                for (int i = 0; i < arr.length; i++) {
                    String s = arr[i];

                    if (babb.startsWith(s) && !prev.equals(s)) {
                        babb = babb.substring(s.length());
                        prev = s;
                    }
                }

                if (length == babb.length()) break;
            }
        }

        return answer;
    }


}
