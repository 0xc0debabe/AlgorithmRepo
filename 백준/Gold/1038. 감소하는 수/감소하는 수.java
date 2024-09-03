import java.util.*;
import java.io.*;

public class Main {
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n >= 1023) {
            System.out.println(-1);
        } else {
            for (int i = 0; i <= 9; i++) {
                dfs(i);
            }

            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void dfs(long target) {
        list.add(target);
        long modValue = target % 10;
        if (modValue == 0) return;

        for (long i = modValue - 1; i >= 0; i--) {
            long newValue = target * 10 + i;
            dfs(newValue);
        }

    }
}