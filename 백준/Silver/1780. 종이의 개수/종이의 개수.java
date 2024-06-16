import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int[] answer = new int[3];
    static int[] paperNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n + 1][n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int v : answer) {
            sb.append(v).append("\n");
        }
        System.out.println(sb);
    }

    static void recursion(int x, int y, int size) {
        if (size == 0) return;

        paperNum = new int[3];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] == -1) {
                    paperNum[0]++;
                } else if (paper[i][j] == 0) {
                    paperNum[1]++;
                } else {
                    paperNum[2]++;
                }
            }
        }

        if (paperNum[0] == size * size) {
            answer[0]++;
        } else if (paperNum[1] == size * size) {
            answer[1]++;
        } else if (paperNum[2] == size * size) {
            answer[2]++;
        } else {
            int newSize = size / 3;
            recursion(x, y, newSize);
            recursion(x, y + newSize, newSize);
            recursion(x, y + 2 * newSize, newSize);

            recursion(x + newSize, y, newSize);
            recursion(x + newSize, y + newSize, newSize);
            recursion(x + newSize, y + 2 * newSize, newSize);

            recursion(x + 2 * newSize, y, newSize);
            recursion(x + 2 * newSize, y + newSize, newSize);
            recursion(x + 2 * newSize, y + 2 * newSize, newSize);
        }
    }
}

