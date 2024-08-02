import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] find, arr, dp;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        dp = new int[n + 1];
        find = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] <= dp[j]) {
                        dp[i] = dp[j] + 1;
                        find[i] = j;
                    }
                }
            }

            if (max < dp[i]) {
                max = dp[i];
                tmp = i;
            }
        }

        sb.append(dp[tmp]).append("\n");
        stack.add(arr[tmp]);
        findArr(find[tmp]);
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static void findArr(int a) {
        if (a == 0) return;
        stack.add(arr[a]);
        findArr(find[a]);
    }
}