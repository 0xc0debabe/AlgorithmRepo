import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[] time;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        price = new int[n + 1];
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    static void dfs(int currDay, int totalPrice) {
        if (currDay >= time.length || time.length < time[currDay] + currDay) {
            answer = Math.max(answer, totalPrice);
            return;
        }

        totalPrice += price[currDay];
        currDay += time[currDay];

        for (int i = currDay; i <= time.length; i++) {
            dfs(i, totalPrice);
        }
    }
}