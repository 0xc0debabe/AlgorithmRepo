import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int range = 1_000_000;
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[range + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            count[num] = 1;
            map.put(num, i);
        }

        int[] answer = new int[n];
        for (int i = 1; i <= range; i++) {
            if (count[i] == 0) continue;

            for (int j = i * 2; j <= range; j += i) {
                if (count[j] == 1) {
                    answer[map.get(i)]++;
                    answer[map.get(j)]--;
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}
