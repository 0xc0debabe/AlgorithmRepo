import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 3, 2, 4, 2};
        sol.solution(a);
    }



    public int[] solution(int[] answers) {
        int[][] nums = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] correctNum = new int[3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            correctNum[i] = isCorrect(i, answers, nums);
            max = Math.max(max, correctNum[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < correctNum.length; i++) {
            if (correctNum[i] == max) list.add(i + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private int isCorrect(int idx, int[] answers, int[][] nums) {
        int correctNum = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            int num = nums[idx][i % (nums[idx].length)];
            if (answer == num) correctNum++;
        }

        return correctNum;
    }

}
