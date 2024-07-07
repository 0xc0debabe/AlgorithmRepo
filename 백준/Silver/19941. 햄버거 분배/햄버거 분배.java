import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[] isVisited;
    static String[] split;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        isVisited = new boolean[n];
        split = br.readLine().split("");
        for (int i = 0; i < n; i++) {
            if (split[i].equals("P")){
                canEat(i);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (isVisited[i]) answer++;
        }
        System.out.println(answer);
    }

    static void canEat(int pos) {
        for (int i = k; i > 0; i--) {
            if (pos - i >= 0) {
                if (split[pos - i].equals("H")) {
                    if (!isVisited[pos - i]) {
                        isVisited[pos - i] = true;
                        return;
                    }
                }
            }
        }

        for (int i = 1; i <= k; i++) {
            if (pos + i < n) {
                if (split[pos + i].equals("H")) {
                    if (!isVisited[pos + i]) {
                        isVisited[pos + i] = true;
                        return;
                    }
                }
            }
        }
    }
}