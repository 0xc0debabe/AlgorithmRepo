import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());
        int[] blank = new int[target + 1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i] > target || arr[i] < 1) continue;
            if (blank[arr[i]] == 1) {
                answer++;
            } else {
                blank[target - arr[i]] = 1;
            }
        }

        System.out.println(answer);
    }
}