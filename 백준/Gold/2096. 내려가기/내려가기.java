import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int prevMaxA = 0;
        int prevMaxB = 0;
        int prevMaxC = 0;

        int prevMinA = 0;
        int prevMinB = 0;
        int prevMinC = 0;

        int maxA = 0;
        int maxB = 0;
        int maxC = 0;

        int minA = 0;
        int minB = 0;
        int minC = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maxA = Math.max(prevMaxA, prevMaxB) + a;
            maxB = Math.max(prevMaxC, Math.max(prevMaxA, prevMaxB)) + b;
            maxC = Math.max(prevMaxB, prevMaxC) + c;

            minA = Math.min(prevMinA, prevMinB) + a;
            minB = Math.min(prevMinC, Math.min(prevMinA, prevMinB)) + b;
            minC = Math.min(prevMinB, prevMinC) + c;

            prevMaxA = maxA;
            prevMaxB = maxB;
            prevMaxC = maxC;

            prevMinA = minA;
            prevMinB = minB;
            prevMinC = minC;
        }

        int max = Math.max(maxC, Math.max(maxA, maxB));
        int min = Math.min(minC, Math.min(minA, minB));

        System.out.println(max + " " + min);
    }
}