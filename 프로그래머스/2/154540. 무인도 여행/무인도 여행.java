import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] a = {"X591X", "X1X5X", "X231X", "1XXX1"};
        sol.solution(a);
    }

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                board[i][j] = c;
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 'X' && !isVisited[i][j]) {
                    isVisited[i][j] = true;
                    list.add(bfs(board, isVisited, i, j, n, m));
                }
            }
        }

        int[] answer = list.stream().sorted().mapToInt(i -> i).toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }

    private int bfs(char[][] board, boolean[][] isVisited, int row, int col, int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        int sum = 0;
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            sum += board[now.row][now.col] - '0';

            for (int i = 0; i < 4; i++) {
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!isVisited[nx][ny] && board[nx][ny] != 'X') {
                        isVisited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }

        return sum;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


}