import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int treeSize = (int) pow(2, (ceil(log(n) / log(2))) + 1);
        int startIndex = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = startIndex + 1; i <= startIndex + n; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        setTree(treeSize - 1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                int index = startIndex + b;
                long diff = c - tree[index];
                while (index > 0) {
                    tree[index] += diff;
                    index /= 2;
                }
            } else {
                int s = startIndex + b;
                int e = startIndex + (int) c;
                long sum = 0;

                while (s <= e) {
                    if (s % 2 == 1) {
                        sum += tree[s];
                        s++;
                    }
                    if (e % 2 == 0) {
                        sum += tree[e];
                        e--;
                    }

                    s /= 2;
                    e /= 2;
                }
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void setTree(int size) {
        while (size != 1) {
            tree[size / 2] += tree[size];
            size--;
        }
    }
}