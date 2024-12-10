class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(18, 3);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {  // i가 yellow의 약수일 때
                int width = i + 2;  // 가로 길이
                int height = yellow / i + 2;  // 세로 길이
                int brownNum = (width + height - 2) * 2;  // brownNum 계산

                if (brownNum == brown) {
                    return new int[]{Math.max(width, height), Math.min(width, height)};
                }
            }
        }
        return new int[]{0, 0};  // 기본적으로 잘못된 값이 들어온 경우
    }
}