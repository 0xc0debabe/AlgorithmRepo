import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        recursion(N, r, c, 0);

    }

    public static void recursion(int N, int r, int c, int size) {
        if (N == 1) {
            if (r == 0 && c == 0) {
                System.out.println(size);
            } else if (r == 0 && c == 1) {
                System.out.println(size + 1);
            } else if (r == 1 && c == 0) {
                System.out.println(size + 2);
            } else {
                System.out.println(size + 3);
            }
            return;
        }

        int pow = (int) Math.pow(2, N); // 8 4
        int halfSize = pow / 2; // 4 2

        if (r < halfSize && c < halfSize) {
            recursion(N - 1, r, c, size);
        } else if (r < halfSize && c >= halfSize) {
            recursion(N - 1, r, c - halfSize, halfSize * halfSize + size);
        } else if (r >= halfSize && c < halfSize) {
            recursion(N - 1, r - halfSize, c, halfSize * halfSize * 2 + size);
        } else {
            recursion(N - 1, r - halfSize, c - halfSize, halfSize * halfSize * 3 + size);
        }
    }
}
