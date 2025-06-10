import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int pos = Integer.parseInt(st.nextToken());
            if (pos == 0) break;
            list.add(pos);
        }

        int[][][] dp = new int[list.size()][5][5];
        System.out.println(ddr(dp, 0, 0, 0));
    }

    private static int ddr(int[][][] dp, int left, int right, int now) {
        if (now == list.size()) return 0;

        if (dp[now][left][right] != 0) {
            return dp[now][left][right];
        }

        int next = list.get(now);
        dp[now][left][right] = Math.min(
                ddr(dp, next, right, now + 1) + findEnergy(left, next),
                ddr(dp, left, next, now + 1) + findEnergy(right, next)
        );

        return dp[now][left][right];
    }

    private static int findEnergy(int prev, int now) {
        if (prev == 0) return 2;

        if (Math.abs(prev - now) == 2) {
            return 4;
        } else if (prev == now) {
            return 1;
        } else return 3;
    }

}