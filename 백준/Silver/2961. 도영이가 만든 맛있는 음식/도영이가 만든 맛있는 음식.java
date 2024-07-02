import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static long answer = Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][2];
        isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(1, 0, 0);

        System.out.println(answer);
    }

    static void dfs(long multiply, long plus, int depth) {
       if (depth == n){
           if (multiply != 1 && plus != 0) {
               answer = Math.min(answer, Math.abs(multiply - plus));
           }
           return;
       }

        long newMultiply = multiply * board[depth][0];
        long newPlus = plus + board[depth][1];

        dfs(newMultiply, newPlus, depth + 1);
        dfs(multiply, plus, depth + 1);
    }
}