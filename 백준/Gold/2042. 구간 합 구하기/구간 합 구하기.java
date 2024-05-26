import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

//        int treeHeight = 0;
//        int length = n;
//        while (length != 0) {
//            length /= 2;
//            treeHeight++;
//        }
//        int treeSize = (int) Math.pow(2, treeHeight + 1);\
//        double v = log(n) / log(2);
//        System.out.println(v);
        int treeSize = (int) pow(2,  (ceil(log(n) / log(2))) + 1);
        int leftStartIdx = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = leftStartIdx + 1; i <= leftStartIdx + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if (a == 1) {
                int index = leftStartIdx + b;
                long diff = e - tree[index];
                while (index > 0) {
                    tree[index] += diff;
                    index /= 2;
                }
            } else {
                int start = leftStartIdx + b;
                int end = leftStartIdx + (int) e;
                long sum = 0;
                while (start <= end) {
                    if (start % 2 == 1) {
                        sum += tree[start];
                        start++;
                    }

                    if (end % 2 == 0) {
                        sum += tree[end];
                        end--;
                    }
                    start /= 2;
                    end /= 2;
                }
                System.out.println(sum);
            }

        }
    }

    private static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
