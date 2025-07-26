import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk =  new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk =  new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] prefixSumArr = new int[n];
        int sum = 0;
        for (int i = 0; i < c; i++) sum += arr[i];
        prefixSumArr[c - 1] = sum;
        for (int i = c; i < n; i++) {
            sum += arr[i] - arr[i - c];
            prefixSumArr[i] = sum;
        }

        int max = Arrays.stream(prefixSumArr).max().getAsInt();
        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        long count = Arrays.stream(prefixSumArr).filter(i -> i == max).count();
        System.out.println(max);
        System.out.println(count);
    }

}