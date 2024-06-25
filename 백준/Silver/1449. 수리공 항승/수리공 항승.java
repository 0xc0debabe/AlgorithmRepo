
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[] board;
    static int n, l, max;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        board = new int[1001];
        max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int water = Integer.parseInt(st.nextToken());
            max = Math.max(max, water);
            board[water] = 1;
        }

        for (int i = 1; i <= max; i++) {
            if (board[i] == 1) {
                if (dfs(0, i)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    static boolean dfs(int depth, int now) {
        if (now > max || depth == l) {
            return false;
        }

        board[now] = 0;
        dfs(depth + 1, now + 1);

        return true;
    }
}