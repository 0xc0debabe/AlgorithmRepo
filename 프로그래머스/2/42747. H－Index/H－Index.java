import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        int answer = 0;
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len - i){
                answer = len - i;
                break;
            }
        }
        return answer;
    }
}