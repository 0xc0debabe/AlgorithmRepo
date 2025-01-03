
class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] as = {1, 3, 4, 6};
        sol.solution(as);
    }

    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        String answer = sb + "0";
        return answer + sb.reverse();
    }


}
