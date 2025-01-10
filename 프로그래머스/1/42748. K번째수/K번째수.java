import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] ar = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        sol.solution(a, ar);
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int j = 0; j < commands.length; j++) {
            int[] command = commands[j];
            int s = command[0] - 1;
            int e = command[1];
            int target = command[2];

            answer[j] = Arrays.stream(array, s, e).sorted().toArray()[target - 1];
        }

        return answer;
    }

}
