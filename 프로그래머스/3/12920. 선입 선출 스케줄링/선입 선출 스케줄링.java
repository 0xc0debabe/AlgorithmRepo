import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int left = 0;
        int right = n * 10000;
        int startTime = 0;
        int work = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int sum = cores.length;
            for(int core : cores) {
                sum += mid / core;
            }
            
            if(n <= sum) {
                startTime = mid;
                work = sum;
                right = mid - 1;
                
            } else {
                left = mid + 1;
            }
        }
        
        work -= n;
        int answer = 0;
        for(int i = cores.length - 1; i >= 0; i--) {
            int core = cores[i];
            if(startTime % core == 0) {
                if(work == 0) {
                    answer = i + 1;
                    break;
                }
                work--;
                
            }
        }
        
        return answer;
    }
    
}