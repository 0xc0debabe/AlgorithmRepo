import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(stk.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arrN);
        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int answer = binaryTree(arrN, Integer.parseInt(stk.nextToken()));
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static int binaryTree(int[] arr, int findNum) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            int target = arr[mid];

            if (target > findNum) {
                end = mid - 1;
            } else if (target < findNum) {
                start = mid + 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}