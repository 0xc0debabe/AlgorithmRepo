import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());

            String s = st.nextToken();
            String[] arr = s.split("");

            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < R; k++) {
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }
}