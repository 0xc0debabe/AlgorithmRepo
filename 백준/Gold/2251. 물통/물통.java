import javax.sound.midi.Receiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] capacity;
    static boolean[][] isVisited = new boolean[201][201];
    static Set<Integer> set = new TreeSet<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        capacity = new int[3];
        for (int i = 0; i < 3; i++) {
            capacity[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0, 0, capacity[2]);

        StringBuilder sb = new StringBuilder();
        for (int value : set) {
            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }

    public static void dfs(int a, int b, int c) {
        if (isVisited[a][b]) {
            return;
        }

        if (a == 0) {
            set.add(c);
        }
        isVisited[a][b] = true;

        //        0 -> 1
        if (a + b > capacity[1]) {
            dfs(a + b - capacity[1], capacity[1], c);
        } else {
            dfs(0, a + b, c);
        }

//        0 -> 2
//        if (a + c > capacity[2]) {
//            dfs(a - (capacity[2] - c), b, capacity[2]);
//        } else {
//            dfs(0, b, a + c);
//        }
        dfs(a, 0, b+c);

//        1 -> 0
        if (b + a > capacity[0]) {
            dfs(capacity[0], a + b - capacity[0], c);
        } else {
            dfs(a + b, 0, c);
        }

        //        1 -> 2
//        if (b + c > capacity[2]) {
//            dfs(a, b - (capacity[2] - c), capacity[2]);
//        } else {
//            dfs(a, 0, b + c);
//        }
        dfs(0, b, a+c);


        //        2 -> 0
        if (a + c > capacity[0]) {
            dfs(capacity[0], b, a + c - capacity[0]);
        } else {
            dfs(a + c, b, 0);
        }
//        2 -> 1
        if (b + c > capacity[1]) {
            dfs(a, capacity[1], c + b - capacity[1]);
        } else {
            dfs(a, b + c, 0);
        }

    }
}
