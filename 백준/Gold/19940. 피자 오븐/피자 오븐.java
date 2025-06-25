import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] ans = new int[5]; // ADDH, ADDT, MINT, ADDO, MINO

            ans[0] = N / 60;
            N %= 60;

            if (N <= 35) {
                if (N % 10 > 5) {
                    ans[1] = N / 10 + 1;
                    ans[4] = 10 - (N % 10);
                } else {
                    ans[1] = N / 10;
                    ans[3] = N % 10;
                }
            } else {
                ans[0]++; // ADDH 한 번 더

                if (N % 10 >= 5) {
                    ans[2] = 6 - (N / 10 + 1); // MINT
                    ans[4] = 10 - (N % 10);    // MINO
                } else {
                    ans[2] = 6 - (N / 10);     // MINT
                    ans[3] = N % 10;           // ADDO
                }
            }

            for (int i = 0; i < 5; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}