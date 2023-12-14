import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int cnt = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (arr[i] == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
