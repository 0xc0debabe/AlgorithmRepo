import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] binaryCnt = new int[20];
        int tmp;
        long answer = 0L;

        for (int i = 0; i < N; i++) {
            int name = Integer.parseInt(br.readLine());
            int idx = 0;

            while (name != 0) {
                tmp = name % 2;
                name /= 2;

                if (tmp == 1) {
                    binaryCnt[idx]++;
                }
                idx++;
            }
        }

        for (int i = 0; i < 20; i++) {
            answer += (long) (Math.pow(2, i) * binaryCnt[i] * (N - binaryCnt[i]));
        }
        System.out.println(answer);
    }
}
