class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcab";
        System.out.println(solution.solution(s));
    }

    public int solution(String s) {
        int n = s.length() / 2;

        int answer = Integer.MAX_VALUE;

        if (s.length() == 1) return 1;
        for (int i = 1; i <= n; i++) {
            String prevStr = "";
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for (int j = 0; j < s.length(); j += i) {
                if (s.length() - i + 1 <= j) {
                    String subStr = s.substring(j);
                    if (prevStr.equals(subStr)) {
                        cnt++;
                    } else {
                        if (cnt == 1) {
                            sb.append(prevStr);
                        } else {
                            sb.append(cnt).append(prevStr);
                        }

                        cnt = 1;
                        prevStr = subStr;
                    }

                    break;
                }
                String subStr = s.substring(j, j + i);
                if (prevStr.equals(subStr)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        sb.append(prevStr);
                    } else {
                        sb.append(cnt).append(prevStr);
                    }
                    prevStr = subStr;
                    cnt = 1;
                }
            }

            if (cnt == 1) {
                sb.append(prevStr);
            } else {
                sb.append(cnt).append(prevStr);
            }

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }
}

