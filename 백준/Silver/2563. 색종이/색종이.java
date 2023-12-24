import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxX = 0;
        int maxY = 0;
        int answer = 0;
        int a = Integer.parseInt(br.readLine());
        int[][] arr = new int[a][2];

        for (int i = 0; i < a; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            arr[i][0] = n;
            arr[i][1] = m;
            if (maxX < n){
                maxX = n;
            }
            if (maxY < m){
                maxY = m;
            }
        }

        int[][] result = new int[maxX+10][maxY+10];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    result[(arr[i][0])+j][(arr[i][1])+k] += 1;
                }
            }
        }

        for (int i = 0; i < maxX+10; i++) {
            for (int j = 0; j < maxY+10; j++) {
                if (result[i][j] >= 1){
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}