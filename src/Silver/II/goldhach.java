package Silver.II;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goldhach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] primeNum = new boolean[1000001];

        for (int i = 2; i < 1000001; i++) {
            if (!primeNum[i]) {
                for (int j = i * 2; j < 1000001; j += i) {
                    primeNum[j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int j = 2; j <= temp / 2; j++) {
                if (!primeNum[j] && !primeNum[temp - j]) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}