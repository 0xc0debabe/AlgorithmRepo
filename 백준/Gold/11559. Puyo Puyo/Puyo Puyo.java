import java.util.*;
import java.io.*;

public class Main {
    static int n = 13, m = 6, answer = 0;
    static char[][] field = new char[n][m];
    static boolean[][] isVisited = new boolean[n][m];
    static List<Puyo> list;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < m; i++) {
            field[0][i] = '.';
        }
        for (int i = 1; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                field[i][j] = s.charAt(j);
            }
        }

        while (true) {
            boolean finish = true;

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (field[i][j] == '.') continue;
                    list = new ArrayList<>();
                    bfs(i, j);

                    if (list.size() >= 4) {
                        finish = false;
                        for (Puyo puyo : list) field[puyo.row][puyo.col] = '.';

                    }
                }
            }

            if (finish) break;
            answer++;
            fall();
        }

        System.out.println(answer);
    }

    static void bfs(int row, int col) {
        Queue<Puyo> queue = new LinkedList<>();
        queue.add(new Puyo(row, col));
        char target = field[row][col];

        while (!queue.isEmpty()) {
            Puyo poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.row + dx[i];
                int ny = poll.col + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && field[nx][ny] == target) {
                    if (!isVisited[nx][ny]) {
                        queue.add(new Puyo(nx, ny));
                        list.add(new Puyo(nx, ny));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }

        for (Puyo puyo : list) isVisited[puyo.row][puyo.col] = false;
    }

    static void fall() {
        for (int i = n - 1; i >= 1; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (field[i][j] == '.') continue;

                int rowTmp = i;
                while (rowTmp < n - 1 && field[rowTmp + 1][j] == '.') {
                    rowTmp++;
                }

                if (rowTmp != i) {
                    field[rowTmp][j] = field[i][j];
                    field[i][j] = '.';
                }


            }
        }
    }

}

class Puyo {
    int row;
    int col;

    public Puyo(int row, int col) {
        this.row = row;
        this.col = col;
    }
}