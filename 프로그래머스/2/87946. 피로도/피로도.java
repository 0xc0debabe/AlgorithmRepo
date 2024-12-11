

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int a = 80;
        int[][] ar = {
                {80, 20},
                {50, 40},
                {30, 10}
        };

        sol.solution(a, ar);
    }

    int answer = 0;
    boolean[] isVisited;
    public int solution(int k, int[][] dungeons) {
        isVisited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return answer;
    }

    void dfs(int[][] dungeons, int nowFatigue, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < dungeons.length; i++) {
            if (!isVisited[i]) {
                if (nowFatigue < dungeons[i][0]) continue;
                isVisited[i] = true;
                dfs(dungeons, nowFatigue - dungeons[i][1], depth + 1);
                isVisited[i] = false;
            }
        }

    }

}