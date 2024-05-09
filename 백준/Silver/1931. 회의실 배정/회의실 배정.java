import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(stk.nextToken());
            arr[i][1] = Integer.parseInt(stk.nextToken());
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] curr, int[] next) {
                if (curr[1] == next[1]) {
                    return curr[0] - next[0];
                }

                return curr[1] - next[1];
            }
        });
        
        int cnt = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= end) {
                end = arr[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}