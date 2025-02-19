class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8, 1);
    }

    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        for (int i = 1; i <= Math.max(yellow / 2, 1); i++) {
            if (yellow % i == 0) {
                if (brown == i * 2 + yellow / i * 2 + 4) {
                    x = i + 2;
                    y = (brown + yellow) / (i + 2);
                    break;
                }
            }
        }

        return new int[]{Math.max(x, y), Math.min(x, y)};
    }

}

