
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();


        int cnt = 0;
        int result = 0;
        for (int i = 1; i < length - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                cnt++;
                if (cnt == n) {
                    cnt--;
                    result++;
                }
                i++;
            } else {
                cnt = 0;
            }
        }

        System.out.println(result);
    }
}