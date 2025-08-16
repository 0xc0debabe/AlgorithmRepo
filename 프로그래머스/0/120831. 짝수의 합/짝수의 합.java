class Solution {
    public int solution(int n) {
        int ret = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0) ret += i;
        }
        
        return ret;
    }
}