import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] arr, tree;
    static final int MAX = 65537;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        tree = new int[MAX * 4];
        arr = new int[n + 1];
        long sum = 0;
        
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            update(0, MAX, 1, arr[i], 1);
            if (i >= k) {
                int midValue = query(0, MAX, 1, (k + 1) / 2);
                sum += midValue;
                update(0, MAX, 1, arr[i - k + 1], -1);
            }
        }

        System.out.println(sum);
    }

    static void update(int start, int end, int node, int idx, int val) {
        if (idx < start || end < idx) return;
        tree[node] += val;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, val);
        update(mid + 1, end, node * 2 + 1, idx, val);
    }

    static int query(int start, int end, int node, int cnt) {
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (tree[node * 2] >= cnt) {
            return query(start, mid, node * 2, cnt);
        } else {
            return query(mid + 1, end, node * 2 + 1, cnt - tree[node * 2]);
        } 
    }
    
}
