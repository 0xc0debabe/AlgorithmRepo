import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[s];
        int right = 0;
        long totalLen = 0;
        for(int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            totalLen += arr[i];
            right = Math.max(right, arr[i]);
        }

        int left = 1;
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;

            int divide = 0;
            for(int v : arr) {
                divide += v / mid;
            }

            if(c <= divide) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }


        System.out.println((totalLen - ((long) answer * c)));
    }

}