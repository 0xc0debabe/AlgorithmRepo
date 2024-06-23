import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isVisited = new boolean[10];
    static int[] blank, maxArr, minArr;
    static char[] sign;
    static int n, min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maxArr = new int[n + 1];
        minArr = new int[n + 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        blank = new int[n + 1];
        sign = new char[n + 1];
        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            sign[i] = split[i - 1].charAt(0);
        }
        solution(0,  0, 0);
        StringBuilder sb = new StringBuilder();
        for (int v : maxArr) {
            sb.append(v);
        }
        sb.append("\n");
        for (int v : minArr) {
            sb.append(v);
        }
        System.out.println(sb);
    }

    static void solution(int depth, int sum, int standard) {
        if (depth == n + 1) {

            if (sum >= max) {
                max = sum;
                for (int i = 0; i <= n; i++) {
                    maxArr[i] = blank[i];
                }
            }

            if (sum < min) {
                min = sum;
                for (int i = 0; i <= n; i++) {
                    minArr[i] = blank[i];
                }
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (depth == 0) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    blank[depth] = i;
                    solution(depth + 1, sum + i, i);
                    isVisited[i] = false;
                }
            }

            if (!isVisited[i]) {
                isVisited[i] = true;

                if (sign[depth] == '<') {
                    if (standard < i) {
                        blank[depth] = i;
                        solution(depth + 1, sum + i, i);
                    }
                } else if (sign[depth] == '>'){
                    if (standard > i) {
                        blank[depth] = i;
                        solution(depth + 1, sum + i, i);
                    }
                }

                isVisited[i] = false;
            }
        }

    }
}
