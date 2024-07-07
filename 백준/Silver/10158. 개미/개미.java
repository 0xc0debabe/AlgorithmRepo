import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int endTime = Integer.parseInt(br.readLine());

        int tmp1 = x + endTime;
        int tmp2 = y + endTime;

        int answer1, answer2;
        if ((tmp1 / w) % 2 == 0) {
            answer1 = tmp1 % w;
        } else {
            answer1 = w - tmp1 % w;
        }

        if ((tmp2 / h) % 2 == 0) {
            answer2 = tmp2 % h;
        } else {
            answer2 = h - tmp2 % h;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer1).append(" ").append(answer2);
        System.out.println(sb);
    }
}