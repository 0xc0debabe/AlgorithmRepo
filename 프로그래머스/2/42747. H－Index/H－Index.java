
import java.util.Arrays;

class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        int[] citations = {5, 4, 7, 1, 2};
        s.solution(citations);
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int answer = 0;
        for(int i = 0; i < len; i++) {
            if(citations[i] <= len - i && citations[i] >= i + 1){
                answer = citations[i];
                answer = Math.max(answer, citations[i]);
            }
        }

        System.out.println(answer);
        return answer;
    }
}
