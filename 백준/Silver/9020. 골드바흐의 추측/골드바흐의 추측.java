import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isPrime = new boolean[10001];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < 10001; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < 10001; j += i) {
                isPrime[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int prime1 = 0;
            int prime2 = 0;

            for (int j = num / 2; j >= 2; j--) {
                if (isPrime[j] && isPrime[num - j]) {
                    prime1 = j;
                    prime2 = num - j;
                    break;
                }
            }

            sb.append(prime1).append(" ").append(prime2).append("\n");
        }

        System.out.println(sb);
    }
}