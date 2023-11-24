package Silver.III;

import java.io.*;
import java.util.StringTokenizer;

public class AlgorithmLessonMergeSort1 {
    static int cnt = 0;
    static int k;
    static int result = -1;
    static int[] tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        tmp = new int[n];
        merge_sort(arr, 0, n - 1);
        System.out.println(result);
    }

    static void merge_sort(int a[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(a, p, q);
            merge_sort(a, q + 1, r);
            merge(a, p, q, r);
        }
    }

    static void merge(int a[], int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[t++] = a[i++];

            } else {
                tmp[t++] = a[j++];

            }
        }

        while (i <= q) {
            tmp[t++] = a[i++];
        }
        while (j <= r) {
            tmp[t++] = a[j++];

        }
        i = p;
        t = 0;
        while (i <= r) {
            cnt++;
            if (cnt == k) {
                result = tmp[t];
                break;
            }
            a[i++] = tmp[t++];
        }
    }
}