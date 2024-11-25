
import java.util.*;


class Solution {
    public static void main(String[] args) {
        int n = 25;
        int[] ar = {2, 14, 11, 21, 17};
        int a = 2;
        Solution s = new Solution();
        s.solution(n, ar, a);

    }


    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int answer = 0;

        int left = 0;
        int right = distance;
        while(left <= right){
            int currRockDist = left + (right - left) / 2;

            int removeRock = 0;
            int before = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - before < currRockDist) {
                    removeRock++;
                } else {
                    before = rocks[i];
                }
            }
            if (distance - before < currRockDist) {
                removeRock++;
            }


            if(removeRock <= n) {
                answer = currRockDist;
                left = currRockDist + 1;
            } else {
                right = currRockDist - 1;
            }
        }

        return answer;
    }

}