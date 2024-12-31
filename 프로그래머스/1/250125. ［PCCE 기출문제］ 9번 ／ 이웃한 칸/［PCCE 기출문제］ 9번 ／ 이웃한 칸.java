

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    public int solution(String[][] board, int h, int w) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int n = board.length;
        int m = board[0].length;

        String standardColor = board[h][w];
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + h;
            int ny = dy[i] + w;

            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (board[nx][ny].equals(standardColor)) {
                    answer++;
                }
            }
                
        }

        return answer;
    }

}
