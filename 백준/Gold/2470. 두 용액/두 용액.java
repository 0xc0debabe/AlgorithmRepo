import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int a1 = 0;
        int a2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                a1 = arr[left];
                a2 = arr[right];
            }

            if (arr[left] + arr[right] > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(a1 + " " + a2);


    }
}
