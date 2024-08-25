import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n + 1];
        long[] psum = new long[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i - 1] + a[i];
        }
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!s.empty() && a[s.peek()] > a[i]) {
                long mn = a[s.pop()];
                long width = psum[i - 1];
                if (!s.empty())
                    width -= psum[s.peek()];
                res = Math.max(res, width * mn);
            }
            s.push(i);
        }

        while (!s.empty()) {
            long mn = a[s.pop()];
            long width = psum[n];
            if (!s.empty())
                width -= psum[s.peek()];
            res = Math.max(res, width * mn);
        }
        System.out.println(res);
    }
}