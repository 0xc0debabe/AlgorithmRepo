import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int woodNum = Integer.parseInt(st.nextToken());
        int cutCost = Integer.parseInt(st.nextToken());
        int perCost = Integer.parseInt(st.nextToken());

        int[] woods = new int[woodNum];
        long max = 0;
        for (int i = 0; i < woodNum; i++) {
            woods[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, woods[i]);
        }

        long answer = 0;
        // i로 나무사이즈를 맞춘다.
        for (int i = 1; i <= max; i++) {
            long totalCost = 0;

            for (int wood : woods) {
                if (wood < i) continue;

                long piece = wood / i;
                long cutCount = (wood % i == 0) ? piece - 1 : piece;

                long income = piece * i * perCost - cutCount * cutCost;
                if (income > 0) {
                    totalCost += income;
                }
            }

            answer = Math.max(answer, totalCost);
        }

        System.out.println(answer);
    }
}