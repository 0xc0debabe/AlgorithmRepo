import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] primeNum = {1, 2, 3, 5, 7, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n, 0, 0);
        System.out.println(sb);
    }

    public static void dfs(int n, int depth, int nextValue) {
        if (depth == n) {
            sb.append(nextValue).append("\n");
            return;
        }

        for (int num : primeNum) {
            int sum = nextValue * 10 + num;

            if (isPrime(sum)) {
                if (num == 1 && depth == 0) {
                    continue;
                }
                dfs(n, depth + 1, sum);
            }
        }
    }

    public static boolean isPrime(int tmp) {
        int num = (int) Math.sqrt(tmp);

        for (int i = 2; i <= num; i++) {
            if (tmp % i == 0) {
                return false;
            }
        }

        return true;
    }
}
