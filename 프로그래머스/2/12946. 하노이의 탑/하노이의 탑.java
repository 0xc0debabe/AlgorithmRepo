import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    private List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return moves.toArray(new int[moves.size()][]);
    }

    private void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, aux, to);
        moves.add(new int[]{from, to});
        hanoi(n - 1, aux, to, from);
    }

}