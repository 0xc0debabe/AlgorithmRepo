import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] as = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] mov = {1, 5, 3, 5, 1, 2, 1, 4};
        sol.solution(as, mov);
    }

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int idx = 0;
            while (idx < board.length) {
                if (board[idx][move - 1] != 0) {
                    stack.add(board[idx][move - 1]);
                    board[idx][move - 1] = 0;
                    break;
                }

                idx++;
            }

            if (stack.size() > 1) {
                int i = stack.get(stack.size() - 1);
                int j = stack.get(stack.size() - 2);
                if (i == j) {
                    stack.pop();
                    stack.pop();
                    answer += 2;
                }
            }

        }

        return answer;
    }

}
