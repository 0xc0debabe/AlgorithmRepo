import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int left = 1;  // 최소 거리는 1부터 시작 (1 미만은 의미가 없음)
        int right = max - min;  // 최대 거리는 max - min

        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 1;
            int start = arr[0];
            int idx = 1;

            while (idx < arr.length) {
                if (arr[idx] - start >= mid) {
                    start = arr[idx];
                    cnt++;
                }
                idx++;
            }

            if (cnt >= target) {  // cnt가 target보다 크거나 같으면, 가능한 경우
                result = mid;  // 현재 mid 값을 기록
                left = mid + 1;  // 더 큰 값을 시도
            } else {
                right = mid - 1;  // 작은 값을 시도
            }
        }

        System.out.println(result);
    }
}