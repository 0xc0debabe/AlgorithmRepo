import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (true){
            int sum = 0;
            int mult = 1;
            int same = cnt;
            int num = 0;

            while (same != 0){
                same /= 10;
                num++;
            }
            same = cnt;

            for (int i = 0; i < num - 2; i++) {
                int prev = mult;
                for (int j = 0; j < 3; j++) {
                    sum += ((same / mult) % 10 * (mult/prev));
                    mult *= 10;
                }
                if (sum  == 666 ){
                    n--;
                    break;
                } else sum = 0;
                mult = prev * 10;
            }


            if (n == 0){
                System.out.println(cnt);
                break;
            }
            cnt++;
            }

    }

}