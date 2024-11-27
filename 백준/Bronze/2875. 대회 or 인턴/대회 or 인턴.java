
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int woman = Integer.parseInt(st.nextToken());
        int man = Integer.parseInt(st.nextToken());
        int out = Integer.parseInt(st.nextToken());

        while (out > 0) {
            if (woman >= man * 2) {
                woman--;
                out--;
            } else {
                man--;
                out--;
            }
        }

        // 100 50 0
        // 100 20 0
        // 20
        // 75 20 0
        //
        // 30 20 0
        int answer = 0;

        while (woman >= 2 && man >= 1) {
            woman -= 2;
            man -= 1;
            answer++;
        }

        System.out.println(answer);

    }

}
