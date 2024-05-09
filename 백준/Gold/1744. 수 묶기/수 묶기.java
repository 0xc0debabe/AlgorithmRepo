import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        -1, 0, 1 개수
//        -1 ~ 이 짝수면 곱, 홀수면 그냥 덧셈
//         0이 있을 시 -1홀수면 곱셈 아니면 그냥 덧셈
//         1은 그냥 덧셈
        int[] blank = new int[3];
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if (arr[i] < 0) {
                blank[0]++;
            } else if (arr[i] == 0) {
                blank[1]++;
            } else {
                blank[2]++;
            }
        }

        Arrays.sort(arr);


        int answer = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                if (blank[0] > 1) {
                    answer += arr[i] * arr[i + 1];
                    blank[0] -= 2;
                    i++;
                } else {
                    if (blank[1] > 0) {
                        blank[1]--;
                    } else {
                        answer += arr[i];
                    }
                }
            } else if (arr[i] == 1) {
                answer += arr[i];
                blank[2]--;
            } else if (arr[i] > 1) {
                if ((arr.length - i) % 2 == 1) {
                    answer += arr[i];
                } else if ((arr.length - i) % 2 == 0) {
                    answer += arr[i] * arr[i + 1];
                    i++;
                }
            }
        }

        System.out.println(answer);
    }
}