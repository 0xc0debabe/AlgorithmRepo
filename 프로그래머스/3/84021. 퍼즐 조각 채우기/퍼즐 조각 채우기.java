import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 0}
        };

        int[][] table = {
                {1, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0, 0}
        };

        solution.solution(board, table);
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n;
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        List<List<int[]>> boardBlocks = getBlocks(game_board, 0);
        List<List<int[]>> tableBlocks = getBlocks(table, 1);
        boolean[] isVisited = new boolean[tableBlocks.size()];
        int answer = 0;
        for (List<int[]> boardBlock : boardBlocks) {
            for (int i = 0; i < tableBlocks.size(); i++) {

                List<int[]> tableBlock = tableBlocks.get(i);
                if (isVisited[i] || boardBlock.size() != tableBlock.size()) continue;

                for (int j = 0; j < 4; j++) {
                    tableBlock = rotate(tableBlock);
                    if (isMatch(boardBlock, tableBlock)) {
                        isVisited[i] = true;
                        answer += tableBlock.size();
                        break;
                    }
                }

                if (isVisited[i]) break;
            }
        }

        return answer;
    }

    private boolean isMatch(List<int[]> boardBlock, List<int[]> tableBlock) {
        for (int i = 0; i < boardBlock.size(); i++) {
            if (
                    boardBlock.get(i)[0] != tableBlock.get(i)[0]
                    || boardBlock.get(i)[1] != tableBlock.get(i)[1]
            ) {
                return false;
            }
        }

        return true;
    }

    private List<int[]> rotate(List<int[]> piece) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : piece) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return standardization(rotated);
    }

    private List<List<int[]>> getBlocks(int[][] board, int target) {
        boolean[][] isVisited = new boolean[n][n];
        List<List<int[]>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && board[i][j] == target) {
                    List<int[]> pieces = new ArrayList<>();
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        pieces.add(now);

                        for (int k = 0; k < 4; k++) {
                            int nr = dr[k] + now[0];
                            int nc = dc[k] + now[1];

                            if (nr >= 0 && nc >= 0 && nr < n && nc < n
                                    && !isVisited[nr][nc] && board[nr][nc] == target) {
                                isVisited[nr][nc] = true;
                                queue.add(new int[]{nr, nc});
                            }
                        }
                    }

                    list.add(standardization(pieces));
                }
            }
        }

        return list;
    }

    private List<int[]> standardization(List<int[]> pieces) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        for (int[] piece : pieces) {
            minX = Math.min(minX, piece[0]);
            minY = Math.min(minY, piece[1]);
        }

        List<int[]> standardPieces = new ArrayList<>();
        for (int[] piece : pieces) {
            standardPieces.add(new int[]{piece[0] - minX, piece[1] - minY});
        }
        standardPieces.sort((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        return standardPieces;
    }

}