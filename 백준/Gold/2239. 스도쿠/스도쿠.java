import javax.management.MBeanRegistration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        dfs(0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == 81){
            flag = true;
            return;
        }


        int row = depth / 9;
        int col = depth % 9;

        if (board[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(row, col, i)) {
                    board[row][col] = i;
                    dfs(depth + 1);
                    if (flag) return;
                    board[row][col] = 0;
                }
            }
        } else {
            dfs(depth + 1);
        }
    }

    static boolean isValid(int row, int col, int target) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == target || board[i][col] == target) return false;
        }

        int newRow = row - row % 3;
        int newCol = col - col % 3;

        for (int i = newRow; i < newRow + 3; i++) {
            for (int j = newCol; j < newCol + 3; j++) {
                if (board[i][j] == target) return false;
            }
        }

        return true;
    }
}
