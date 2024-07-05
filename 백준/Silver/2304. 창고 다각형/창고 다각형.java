import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lh = new int[1001];

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            lh[l] = h;
            left = Math.min(left, l);
            right = Math.max(right, l);
        }

        int answer = 0;
        int prevL = 0;
        int prevR = 0;

        while (left <= right) {
            if (lh[left] < lh[right]) {
                if (prevL < lh[left]) {
                    prevL = lh[left];
                }

                answer += prevL;
                left++;
            } else {
                if (prevR < lh[right]) {
                    prevR = lh[right];
                }

                answer += prevR;
                right--;
            }
        }

        System.out.println(answer);
    }
}
