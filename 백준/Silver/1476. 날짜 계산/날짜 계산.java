import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int year = 1;
        while(true) {
            int a = year % 15 == 0 ? 15 : year % 15;
            int b = year % 28 == 0 ? 28 : year % 28;
            int c = year % 19 == 0 ? 19 : year % 19;

            if (a == e && b == s && c == m) break;
            year++;
        }

        System.out.println(year);
    }
}