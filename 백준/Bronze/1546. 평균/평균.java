import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        double sum = 0;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(stk.nextToken());
            if (max < j) {
                max = j;
            }
            sum += j;
        }

        System.out.println(sum / n / max * 100);
    }

}