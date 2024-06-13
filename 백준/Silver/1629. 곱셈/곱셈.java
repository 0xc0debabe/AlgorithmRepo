import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(fastPow(a, b, c));
    }

    public static long fastPow(long a, long b, long c) {
        if (b == 1) return a % c;

        long division = fastPow(a, b / 2, c);

        if (b % 2 == 1) {
            return (division * division % c) * a % c;
        } else {
            return division * division % c;
        }
    }

//    public static long fastPow(long a, long b, long c) {
//        if (b == 1) return a % c;
//
//        long division = fastPow(a, b / 2, c);
//
//        if (division % 2 == 1) {
//            return (division * division) % c * a % c;
//        } else {
//            return (division * division) % c;
//        }
//    }

//    public static long fastPow(long a, long b, long c) {
//        if (b == 1) return a % c;
//
//        long division = fastPow(a, b / 2, c);
//
//        if (division % 2 == 1) {
//            return ((division % c) * (division % c) * (a % c)) % c;
//        } else {
//            return (division % c) * (division % c) % c;
//        }
//    }
}
