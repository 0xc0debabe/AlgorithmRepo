import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] isVisited = new int[d + 1];
        int[] arr = new int[n + 1 + k];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < k; i++) {
            arr[i + n] = arr[i];
        }


        int left = 1;
        int right = 1;

        int cnt = 0;
        int answer = 0;

        while (left <= n) {
            if (right - left < k) {

                if (isVisited[arr[right]] == 0) cnt++;

                isVisited[arr[right]]++;
                right++;
            }

            if (right - left == k) {

                if (answer <= cnt) {
                    int tmp = cnt;
                    if (isVisited[c] == 0) {
                        tmp++;
                    }
                    answer = tmp;
                }

                if (answer == k + 1) break;


                isVisited[arr[left]]--;

                if (isVisited[arr[left]] == 0) cnt--;
                left++;
            }
        }

        System.out.println(answer);
    }
}
