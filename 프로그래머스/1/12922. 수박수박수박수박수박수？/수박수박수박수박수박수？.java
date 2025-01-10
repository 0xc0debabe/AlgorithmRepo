class Solution {
    public String solution(int n) {
        String answer = "";
        
        if(n % 2 == 0) {
            int tmp = n / 2;
            for(int i=0; i < tmp; i++){
                answer += "수박";
            }
        } else {
            int tmp = n / 2;
            for(int i=0; i < tmp; i++){
                answer += "수박";
            }
            answer += "수";
        }
        
        return answer;
    }
}