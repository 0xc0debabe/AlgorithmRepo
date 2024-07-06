import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static String[][] board = new String[5][5];
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, " ");
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int row, int col, int depth, String s) {
        if (depth == 6) {
            set.add(s);
            return;
        }

        if (row < 0 || col < 0 || row >= 5 || col >= 5){
            return;
        }



        s += board[row][col];

        dfs(row + 1, col, depth + 1, s);
        dfs(row - 1, col, depth + 1, s);
        dfs(row, col + 1, depth + 1, s);
        dfs(row, col - 1, depth + 1, s);
    }
}
