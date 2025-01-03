
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] asdf = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        sol.solution(4, 3, asdf);
    }

    public int solution(int k, int m, int[] score) {
        score = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();

        int answer = 0;
        for (int i = 0; i < score.length; i++) {
            int min = Integer.MAX_VALUE;

            if (i + m <= score.length) {
                for (int j = i; j < i + m; j++) {
                    min = Math.min(min, score[j]);
                }

                answer += min * m;
            }


            i += m - 1;
        }

        return answer;
    }


}
