    class Solution {
        public static void main(String[] args) {
            Solution sol = new Solution();
            int n = 3;
            int[] arr = {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
            sol.solution(n, arr);
        }

        int[] answer = new int[11];
        int max_score = 0;
        public int[] solution(int n, int[] info) {
            int[] lion = new int[info.length];
            backTracking(n, info, lion, 0, 0);
            if (max_score == 0) return new int[]{-1};

            return answer;
        }

    //    0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 ->
    //    1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0 -> answer 10 9 8 6 5 4 42
    //    1, 1, 1, 1, 1, 1, 1, 2, 0, 0, 0 ->
        private void backTracking(int n, int[] peach, int[] lion, int depth, int idx) {
            if (depth == n) {
                int peachScore = 0;
                int lionScore = 0;

                for (int i = 0; i <= 10; i++) {
                    if (peach[i] > 0 || lion[i] > 0) {
                        if (peach[i] >= lion[i]) {
                            peachScore += 10 - i;
                        } else {
                            lionScore += 10 - i;
                        }
                    }
                }

                if(lionScore - peachScore > max_score){
                    max_score = lionScore - peachScore;
                    answer = lion.clone();
                } else if( lionScore - peachScore == max_score){
                    for(int i = 10; i >= 0 ; i--){
                        if(answer[i] < lion[i]){
                            answer = lion.clone();
                            break;
                        }

                        if(answer[i] > lion[i] )break;
                    }
                }

                return;
            }

            for (int i = idx; i < 11; i++) {
                if (peach[i] < lion[i]) continue;
                lion[i]++;
                backTracking(n, peach, lion, depth + 1, i);
                lion[i]--;
            }
        }

    }
