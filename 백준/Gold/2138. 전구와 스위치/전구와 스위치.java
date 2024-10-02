import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String now = br.readLine();
        String target = br.readLine();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] targetArr = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = now.charAt(i) - '0';
            arr2[i] = now.charAt(i) - '0';
        }
        for (int i = 0; i < n; i++) {
            targetArr[i] = target.charAt(i) - '0';
        }
        arr1 = toggle(arr1, 0, n);

        int a = 1;
        int b = 0;
        for (int i = 1; i < n; i++) {
            if (arr1[i - 1] != targetArr[i - 1]) {
                arr1 = toggle(arr1, i, n);
                a++;
            }

            if (arr2[i - 1] != targetArr[i - 1]) {
                arr2 = toggle(arr2, i, n);
                b++;
            }
        }
        int answer = Integer.MAX_VALUE;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (arr1[i] != targetArr[i]) {
                flag = true;
                break;
            }
        }
        if (!flag) answer = Math.min(answer, a);
        flag = false;
        for (int i = 0; i < n; i++) {
            if (arr2[i] != targetArr[i]) {
                flag = true;
                break;
            }
        }
        if (!flag) answer = Math.min(answer, b);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int[] toggle(int[] arr, int i, int n) {
        if (i > 0) {
            if (arr[i - 1] == 0) {
                arr[i - 1] = 1;
            } else {
                arr[i - 1] = 0;
            }
        }


        if (arr[i] == 0) {
            arr[i] = 1;
        } else {
            arr[i] = 0;
        }

        if (i < n - 1) {
            if (arr[i + 1] == 0) {
                arr[i + 1] = 1;
            } else {
                arr[i + 1] = 0;
            }
        }

        return arr;
    }
}
