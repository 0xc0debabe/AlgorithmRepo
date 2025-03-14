import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        int maxPeerScore = 0;
        List<int[]> validEmployees = new ArrayList<>();
        
        for (int[] score : scores) {
            if (score[1] < maxPeerScore) {
                if (Arrays.equals(score, wanho)) return -1;
            } else {
                validEmployees.add(score);
                maxPeerScore = Math.max(maxPeerScore, score[1]);
            }
        }
        
        List<Integer> totalScores = new ArrayList<>();
        for (int[] emp : validEmployees) {
            totalScores.add(emp[0] + emp[1]);
        }
        
        totalScores.sort(Collections.reverseOrder());
        int wanhoTotal = wanho[0] + wanho[1];
        
        return totalScores.indexOf(wanhoTotal) + 1;
    }
}
