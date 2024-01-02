import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int a = Integer.parseInt(br.readLine());

            if (a == -1) break;

            int[] arr = new int[a];

            int sum = 0;


            for (int i = 1; i <= a; i++) {
                if ((a % i == 0) && (i != a)) {
                    arr[i] = i;
                    sum += i;
                }
            }

            if (sum != a) {
                sb.append(a + " is NOT perfect.");
            } else {
                sb.append(a + " = 1");
                for (int j = 1; j <= a; j++) {
                    if (arr[j - 1] != 0 && arr[j - 1] != 1) {
                        sb.append(" + " + arr[j - 1]);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}