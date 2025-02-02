class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
//      ret = [0,2,2,0,1,0,0,0,0,0,0]
        solution.solution(5, info);
    }


    static int[] res = { -1 };
    static int max = -1000;
    
    public int[] solution(int n, int[] info) {
        int[] lion = new int[11];
        dfs(info, 1, n, lion);
        return res;
    }
    
    public void dfs(int[] info, int cnt, int n, int[] lion) {
        if(cnt == n+1) {
            int apeach_point = 0;
            int lion_point = 0;
            for(int i = 0; i <= 10; i++) {
                if(info[i] != 0 || lion[i] != 0) {
                    if(info[i] < lion[i]) lion_point += 10 - i;
                    else apeach_point += 10 - i;
                }
            }
            
            if(lion_point > apeach_point) {
                if(lion_point - apeach_point >= max)
                {
                    res = lion.clone();
                    max = lion_point - apeach_point;
                }
            }
            
            return ;
        }
        
        for(int j = 0; j <= 10 && lion[j] <= info[j]; j++) {
            lion[j]++;
            dfs(info, cnt + 1, n, lion);
            lion[j]--;
        }
        
    }
    

}