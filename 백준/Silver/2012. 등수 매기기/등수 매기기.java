import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] expected = new int[n];
        for (int i = 0; i < n; i++) {
            expected[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(expected);

        long totalUnhappiness = 0;
        for (int i = 0; i < n; i++) {
            int realRank = i + 1;
            totalUnhappiness += Math.abs(expected[i] - realRank);
        }

        System.out.println(totalUnhappiness);
    }
}