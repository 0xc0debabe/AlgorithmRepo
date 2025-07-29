import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n - 1;
            int count = 0;
            int closeNum = Integer.MAX_VALUE;

            while(left < right) {
                int leftNum = arr[left];
                int rightNum = arr[right];
                int sum = leftNum + rightNum;
                int tmp = Math.abs(target - sum);
                if(closeNum == tmp) {
                    count++;
                } else if(closeNum > tmp) {
                    count = 1;
                    closeNum = tmp;
                }

                if(target > sum) {
                    left++;
                } else {
                    right--;
                }

            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }

}