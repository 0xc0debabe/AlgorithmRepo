import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] distance = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) distance[i][j] = 1_000_000;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            distance[from][to] = 1;
            distance[to][from] = 1;
        }

        int[] answer = new int[n + 1];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer[i] = Arrays.stream(distance[i]).sum();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (min > answer[i]) {
                min = answer[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (answer[i] == min){
                System.out.println(i);
                break;
            }
        }

    }
}