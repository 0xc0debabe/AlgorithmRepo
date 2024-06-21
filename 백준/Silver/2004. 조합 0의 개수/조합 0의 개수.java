import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        int upFive = five(n, 0);
        int upTwo = two(n, 0);

        int downFive1 = five(m, 0);
        int downTwo1 = two(m, 0);

        int downFive2 = five(n - m, 0);
        int downTwo2 = two(n - m, 0);

        upFive = upFive - downFive1 - downFive2;
        upTwo = upTwo - downTwo1 - downTwo2;
        System.out.println(Math.min(upFive, upTwo));
    }

    static int five(long n, int cnt) {
        if (n == 0){
            return cnt;
        }

        cnt += (int) n / 5;
        return five(n / 5, cnt);
    }

    static int two(long n, int cnt) {
        if (n == 0){
            return cnt;
        }

        cnt += (int) n / 2;
        return two(n / 2, cnt);
    }
}