
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        if (permutation()) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
        } else sb.append(-1);
        System.out.println(sb);

    }

    static boolean permutation() {
        int i = arr.length - 1;
        while (i > 0 && arr[i] < arr[i - 1]) {
            i--;
        }
        if (i == 0) return false;

        int min = Integer.MAX_VALUE;
        int j = i;
        int tmp = 0;
        while (j <= arr.length - 1) {
            if (min > arr[j] && arr[i - 1] < arr[j]) {
                min = arr[j];
                tmp = j;
            }
            j++;
        }
        int tmp2 = arr[i - 1];
        arr[i - 1] = arr[tmp];
        arr[tmp] = tmp2;
        int idx = 0;
        for (int k = i; k < (arr.length - i) / 2 + i; k++) {
            int tmp3 = arr[k];
            arr[k] = arr[arr.length - 1 - idx];
            arr[arr.length - 1 - idx] = tmp3;
            idx++;
        }
        return true;
    }

}