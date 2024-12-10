
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(18, 3);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }


    public int[] solution(int brown, int yellow) {
//        if (yellow % 2 == 1) {
//            int a = yellow + 2;
//            int b = 3;
//            return new int[]{Math.max(a, b), Math.min(a, b)};
//        }

        int a = 0;
        int b = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int width = i + 2;
                int height = yellow / i + 2;
                int brownNum = width * height - yellow;

                if (brownNum == brown) {
                    a = i + 2;
                    b = yellow / i + 2;
                    break;
                }
            }
        }

        return new int[]{Math.max(a, b), Math.min(a, b)};
    }

}