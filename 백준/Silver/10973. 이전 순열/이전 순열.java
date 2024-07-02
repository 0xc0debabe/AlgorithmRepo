import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        if (!permutation()) {
            sb.append(-1);
        } else {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
        }
        System.out.println(sb);
    }

    static boolean permutation() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] < arr[i]) i--;
        if (i == 0) return false;

        int j = arr.length - 1;
        while (j > 0 && arr[i - 1] < arr[j]) j--;
        swap(i - 1, j);

        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i++; j--;
        }

        return true;
    }

    static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}