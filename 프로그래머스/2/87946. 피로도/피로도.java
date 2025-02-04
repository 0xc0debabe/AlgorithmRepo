    class Solution {
        public static void main(String[] args) {
            Solution sol = new Solution();
        }

        boolean[] isVisited;
        int ret = 0;
        public int solution(int k, int[][] dungeons) {
            isVisited = new boolean[dungeons.length];
            dfs(dungeons, k, 0);
            return ret;
        }

        private void dfs(int[][] dungeons, int health, int cnt) {
            ret = Math.max(cnt, ret);

            for (int i = 0; i < dungeons.length; i++) {
                if (isVisited[i] || dungeons[i][0] > health) continue;

                isVisited[i] = true;
                dfs(dungeons, health - dungeons[i][1], cnt + 1);
                isVisited[i] = false;
            }
        }

    }
