import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] decFuel = new int[n - 1];
        int[] incFuel = new int[n];
        int min = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            decFuel[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            incFuel[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < n - 1; i++) {
            if (min > incFuel[i]) {
                min = incFuel[i];
            }
            answer += min * decFuel[i];
        }
        System.out.println(answer);
    }
}