import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;


public class Main {
    static long[] tree;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int size = (int) pow(2, ceil(log(n) / log(2)) + 1);
        int startIdx = size / 2 - 1;
        tree = new long[size + 1];
        Arrays.fill(tree, 1);
        for (int i = startIdx + 1; i <= startIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(size - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                change(startIdx + b, c);
            } else {
                System.out.println(findNum(b +startIdx, (int)(c + startIdx)));
            }
        }
    }

    private static long findNum(int s, int e) {
        long sum = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                sum = sum * tree[s] % MOD;
                s++;
            }
            if (e % 2 == 0) {
                sum = sum * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return sum;
    }

    private static void change(int index, long val) {
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD;
        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = tree[i / 2] * tree[i] % MOD;
            i--;
        }
    }
}