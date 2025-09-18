import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] tips = new int[n];
        for(int i = 0; i < n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        tips = Arrays.stream(tips).boxed().sorted((x, y) -> y - x).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i < n; i++) {
            int tip = tips[i] - i;
            answer += Math.max(tip, 0);
        }

        System.out.println(answer);
    }
}