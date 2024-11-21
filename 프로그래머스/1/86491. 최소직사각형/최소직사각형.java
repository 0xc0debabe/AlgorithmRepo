
import java.util.*;

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int a = 6;
        int[][] ar = {
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        };
        System.out.println(s.solution(ar));

    }

    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            int i = Math.max(size[0], size[1]);
            int j = Math.min(size[0], size[1]);

            if (x < i) {
                x = i;
            }

            if (y < j) {
                y = j;
            }
        }

        return x * y;
    }

}
