import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = -1;
        int x = 0;

        while (n >= x * 3){
                x++;
        }

        int[] arr = new int[(x+1)*(x+1)];
        kong : for (int i = x; i >= 0; i--) {

            for (int j = 0; j <= x; j++) {
                arr[i+j] = 5 * i + 3 * j;

                if (arr[i+j] == n){
                    answer = i + j;
                    break kong;
                }
            }
        }

        System.out.println(answer);
    }
}