
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int maxWidth = 0;
        int maxHeight = 0;
        int[] arr = new int[6];

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            if (dir == 1 || dir == 2) {
                maxWidth = Math.max(maxWidth, len);
            } else {
                maxHeight = Math.max(maxHeight, len);
            }

            arr[i] = len;
        }

        int width = 0, height = 0;

        for (int i = 0; i < 6; i++) {
            if (arr[i] == maxWidth) {
                int tmp1, tmp2;
                if (i == 0) {
                    tmp1 = arr[5];
                    tmp2 = arr[1];
                    height = Math.min(tmp1, tmp2);
                } else if (i == 5) {
                    tmp1 = arr[0];
                    tmp2 = arr[4];
                    height = Math.min(tmp1, tmp2);
                } else {
                    tmp1 = arr[i - 1];
                    tmp2 = arr[i + 1];
                    height = Math.min(tmp1, tmp2);
                }
            }

            if (arr[i] == maxHeight) {
                int tmp1, tmp2;
                if (i == 0) {
                    tmp1 = arr[5];
                    tmp2 = arr[1];
                    width = Math.min(tmp1, tmp2);
                } else if (i == 5) {
                    tmp1 = arr[0];
                    tmp2 = arr[4];
                    width = Math.min(tmp1, tmp2);
                } else {
                    tmp1 = arr[i - 1];
                    tmp2 = arr[i + 1];
                    width = Math.min(tmp1, tmp2);
                }
            }
        }

        long answer = (long) maxWidth * maxHeight - ((long) (maxWidth - width) * (maxHeight - height));
        System.out.println(answer * n);
    }
}