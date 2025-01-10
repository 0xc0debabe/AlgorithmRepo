import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {4};
        System.out.println(sol.solution(arr, 3));
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int[] prefixSum = new int[d.length];
        if (d[0] > budget) return 0;
        prefixSum[0] = d[0];
        int answer = 0;
        for (int i = 1; i < d.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + d[i];
            if (prefixSum[i] > budget){
                answer = i;
                break;
            }

        }
        return answer == 0 ? d.length : answer;
    }

}
