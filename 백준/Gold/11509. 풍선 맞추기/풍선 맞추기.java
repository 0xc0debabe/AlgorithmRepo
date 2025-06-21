import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int range = 1_000_001;
        int[] count = new int[range];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (count[arr[i]] == 0) {
                answer++;
                count[arr[i] - 1]++;
            } else if (count[arr[i]] > 0) {
                count[arr[i]]--;
                count[arr[i] - 1]++;
            }
        }
        System.out.println(answer);
    }
}