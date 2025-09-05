import java.io.*;
import java.util.*;

class Main {
    static long N, P, Q;
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        System.out.println(dfs(N));
    }

    static long dfs(long n) {
        if(n == 0) return 1;
        if (map.containsKey(n)) return map.get(n);

        long res = dfs(n / P) + dfs(n / Q);
        map.put(n, res);
        return res;
    }
}