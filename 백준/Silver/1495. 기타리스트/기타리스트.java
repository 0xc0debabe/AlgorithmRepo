import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[] arr;
    static int songNum, startVolume, maxVolume;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        songNum = Integer.parseInt(st.nextToken());
        startVolume = Integer.parseInt(st.nextToken());
        maxVolume = Integer.parseInt(st.nextToken());


        arr = new int[songNum + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= songNum; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[songNum + 1][1001];

        recursion(0, startVolume);

        int answer = -1;
        for (int i = maxVolume; i >= 0; i--) {
            if (dp[songNum][i] == 1) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    static void recursion(int row, int col) {
        if (col > maxVolume || row > songNum || col < 0 || dp[row][col] == 1) {
            return;
        }

        dp[row][col] = 1;

        if (songNum > row) {
            recursion(row + 1, col + arr[row + 1]);
            recursion(row + 1, col - arr[row + 1]);
        }
    }
}
