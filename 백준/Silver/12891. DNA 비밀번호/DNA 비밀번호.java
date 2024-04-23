import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        String dna = br.readLine();

        stk = new StringTokenizer(br.readLine());
        int[] dnaArr = new int[4]; // A, C, G, T
        for (int i = 0; i < 4; i++) {
            dnaArr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] dnaArr2 = new int[4];
        for (int i = 0; i < m; i++) {
            char ACGT = dna.charAt(i);
            if (ACGT == 'A') {
                dnaArr2[0]++;
            } else if (ACGT == 'C') {
                dnaArr2[1]++;
            } else if (ACGT == 'G') {
                dnaArr2[2]++;
            } else if (ACGT == 'T') {
                dnaArr2[3]++;
            }
        }

        int answer = 0;
        if (dnaArr[0] <= dnaArr2[0]
                && dnaArr[1] <= dnaArr2[1]
                && dnaArr[2] <= dnaArr2[2]
                && dnaArr[3] <= dnaArr2[3]) {
            answer++;
        }
        int start = 0;

        for (int i = m; i < dna.length(); i++) {
            char firstACGT = dna.charAt(start);

            if (firstACGT == 'A') {
                dnaArr2[0]--;
            } else if (firstACGT == 'C') {
                dnaArr2[1]--;
            } else if (firstACGT == 'G') {
                dnaArr2[2]--;
            } else if (firstACGT == 'T') {
                dnaArr2[3]--;
            }

            char lastACGT = dna.charAt(i);
            if (lastACGT == 'A') {
                dnaArr2[0]++;
            } else if (lastACGT == 'C') {
                dnaArr2[1]++;
            } else if (lastACGT == 'G') {
                dnaArr2[2]++;
            } else if (lastACGT == 'T') {
                dnaArr2[3]++;
            }
            start++;
            if (dnaArr[0] <= dnaArr2[0]
                    && dnaArr[1] <= dnaArr2[1]
                    && dnaArr[2] <= dnaArr2[2]
                    && dnaArr[3] <= dnaArr2[3]) {
                answer++;
            }
        }


        System.out.println(answer);
    }
}
