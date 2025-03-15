class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution.solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int size = 2 * m + n - 2;
        int[][] board = new int[size][size];

        for (int i = m; i < m + n; i++) {
            for (int j = m; j < m + n; j++) {
                board[i - 1][j - 1] = lock[i - m][j - m];
            }
        }

        boolean answer = false;

        for (int d = 0; d < 4; d++) {
            for (int i = 0; i < size - m + 1 && !answer; i++) {
                for (int j = 0; j < size - m + 1 && !answer; j++) {
                    addKey(board, key, i, j, m);
                    if (check(board, m, n)) {
                        answer = true;
                    }
                    subtractKey(board, key, i, j, m);
                }
            }
            
            if(d != 3) key = rotate(key);
        }

        return answer;
    }

    private void addKey(int[][] board, int[][] key, int sr, int sc, int keySize) {
        for (int i = sr; i < sr + keySize; i++) {
            for (int j = sc; j < sc + keySize; j++) {
                board[i][j] += key[i - sr][j - sc];
            }
        }
    }

    private void subtractKey(int[][] board, int[][] key, int sr, int sc, int keySize) {
        for (int i = sr; i < sr + keySize; i++) {
            for (int j = sc; j < sc + keySize; j++) {
                board[i][j] -= key[i - sr][j - sc];
            }
        }
    }

    private boolean check(int[][] board, int m, int n) {
        for (int i = m; i < m + n; i++) {
            for (int j = m; j < m + n; j++) {
                if (board[i - 1][j - 1] != 1) return false;
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key) {
        int length = key.length;
        int[][] newKey = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                newKey[i][j] = key[length - j - 1][i];
            }
        }

        return newKey;
    }

}