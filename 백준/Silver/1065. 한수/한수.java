import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n > 99) {
            answer += 99;
            for (int i = 100; i <= n; i++) {
                int[] a = new int[(int) Math.log10(i)];
                int idx = 0;
                int tmp = i;
                while (tmp >= 10) {
                    int num1 = tmp % 10;
                    tmp /= 10;
                    int num2 = tmp % 10;
                    a[idx++] = num1 - num2;
                }

                boolean check = true;
                for (int j = 0; j < a.length - 1; j++) {
                    if (a[j] != a[j + 1]) {
                        check = false;
                        break;
                    }
                }

                if (check){
                    answer++;}

            }

        } else {
            answer = n;
        }

        System.out.println(answer);
    }

}