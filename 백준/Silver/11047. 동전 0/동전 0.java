import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coinTypes = new int[n];
        for (int i = 0; i < n; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }
        int[] array = Arrays.stream(coinTypes)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int cnt = 0;
        for (int coinType : array) {
            if (coinType <= k) {
                cnt += k / coinType;
                k -= coinType * (k / coinType);
            }
        }

        System.out.println(cnt);
    }

}
