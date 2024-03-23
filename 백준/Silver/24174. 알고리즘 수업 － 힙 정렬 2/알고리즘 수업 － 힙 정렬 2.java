
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int targetCnt;
    private static int cnt = 0;
    private static boolean flag = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        targetCnt = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(arr);

        if (!flag) {
            bw.write(String.valueOf(-1));
            bw.flush();
        }
        bw.close();
        br.close();
    }


    static void swap(int[] arr, int a, int b) throws IOException {
        cnt++;

        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

        if (cnt == targetCnt) {
            for (int i = 1; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.flush();
            flag = true;
        }
    }

    static void heapSort(int[] arr) throws IOException {
        buildMinHeap(arr, arr.length - 1);
        for (int i = arr.length - 1; i > 1; i--) {
            swap(arr, 1, i);
            heapify(arr, 1, i - 1);
        }
    }


    static void buildMinHeap(int[] arr, int N) throws IOException {
        for (int i = N / 2; i >= 1 && !flag; i--) {
            heapify(arr, i, N);
        }
    }

    static void heapify(int[] arr, int K, int N) throws IOException {
        int left = 2 * K;
        int right = 2 * K + 1;
        int smaller;

        if (right <= N) {
            if (arr[left] < arr[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= N) {
            smaller = left;
        } else {
            return;
        }

        if (arr[smaller] < arr[K]) {
            swap(arr, K, smaller);
            heapify(arr, smaller, N);
        }
    }
}
