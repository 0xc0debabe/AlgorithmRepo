import javax.management.MBeanRegistration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] px = new int[3];
        int[] py = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            px[i] = Integer.parseInt(st.nextToken());
            py[i] = Integer.parseInt(st.nextToken());
        }

        int sumA = 0;
        for (int i = 0; i < 2; i++) {
            sumA += px[i] * py[i + 1];
        }
        sumA += px[2] * py[0];

        int sumB = 0;
        for (int i = 1; i < 3; i++) {
            sumB += px[i] * py[i - 1];
        }
        sumB += px[0] * py[2];

        int i = sumA - sumB;
        if (i > 0) {
            System.out.println(1);
        } else if (i < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }

}
