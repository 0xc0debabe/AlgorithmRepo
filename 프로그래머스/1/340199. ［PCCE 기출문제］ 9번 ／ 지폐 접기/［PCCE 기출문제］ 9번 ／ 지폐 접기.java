
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ar = {30, 15};
        int[] ar2 = {26, 17};

        solution.solution(ar, ar2);
    }

    public int solution(int[] wallet, int[] bill) {
        int min = Math.min(wallet[0], wallet[1]);
        int max = Math.max(wallet[0], wallet[1]);
        boolean ended = false;
        int answer = 0;

        while (!ended) {
            int billMin = Math.min(bill[0], bill[1]);
            int billMax = Math.max(bill[0], bill[1]);
            
            if (shouldFoldBill(min, max, billMin, billMax)) {
                billMax /= 2;
                bill[0] = billMax;
                bill[1] = billMin;
                answer++;
                continue;
            }

            ended = true;
        }

        return answer;
    }

    private boolean shouldFoldBill(int min, int max, int billMin, int billMax) {
        if (min >= billMin && max >= billMax) {
            return false;
        }

        return true;
    }

}
