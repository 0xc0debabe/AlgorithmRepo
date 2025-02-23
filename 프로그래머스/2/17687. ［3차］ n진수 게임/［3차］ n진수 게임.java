class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, 4, 2, 1));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toUnsignedString(num++, n).toUpperCase());
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(sb.charAt((p - 1) + (i * m))); // p 번째부터 m 간격으로 t개 추출
        }

        return answer.toString();
    }

}

