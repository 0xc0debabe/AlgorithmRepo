import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int answer = 0;
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if (solution(startX, startY, cx, cy, r) && solution(endX, endY, cx, cy, r)) {
                    continue;
                }

                if (solution(startX, startY, cx, cy, r)) {
                    answer++;
                }

                if (solution(endX, endY, cx, cy, r)) {
                    answer++;
                }


            }

            System.out.println(answer);
        }
    }

    static boolean solution(int x, int y, int cx, int cy, int r) {
        double diagonal = Math.sqrt(Math.pow(Math.abs(cx - x), 2) + Math.pow(Math.abs(cy - y), 2));
        if (r > diagonal) return true;

        return false;
    }
}