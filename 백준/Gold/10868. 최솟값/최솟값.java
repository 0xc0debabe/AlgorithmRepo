import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;


public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int treeSize = (int) pow(2, ceil(log(n) / log(2)) + 1);
        tree = new long[treeSize + 1];
        Arrays.fill(tree, 1_000_000_001);
        int startIdx = treeSize / 2 - 1;
        for (int i = startIdx + 1; i <= startIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(findMin(s + startIdx, e + startIdx)).append("\n");
        }

        System.out.println(sb);
    }

    private static long findMin(int s, int e) {
        long minValue = Long.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                minValue = min(minValue, tree[s]);
                s++;
            }
            if (e % 2 == 0) {
                minValue = min(minValue, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }

        return minValue;
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] = min(tree[i / 2], tree[i]);
            i--;
        }
    }
}