import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] xArr = new int[n];
        int[] yArr = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xArr[i] = Integer.parseInt(st.nextToken());
            yArr[i] = Integer.parseInt(st.nextToken());
        }

        long xSum = 0, ySum = 0;

        for (int i = 0; i < n - 1; i++) {
            xSum += (long) xArr[i] * yArr[i + 1];
        }
        xSum += (long) xArr[n - 1] * yArr[0];

        for (int i = 1; i < n; i++) {
            ySum += (long) xArr[i] * yArr[i - 1];
        }
        ySum += (long) xArr[0] * yArr[n - 1];

        double l = (double) Math.abs(xSum - ySum) / 2;
        String format = String.format("%.1f", l);
        System.out.println(format);
    }
}
