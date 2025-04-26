
import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;
        while(right < n) {
            if (arr[right] > m) {
                right++;
                sum = 0;
                left = right;
                continue;
            }

            if(sum + arr[right] <= m) {
                sum += arr[right];
                right++;
            } else {
                sum -= arr[left];
                left++;
            }

            answer = Math.max(sum, answer);
        }

        System.out.println(answer);
    }
}