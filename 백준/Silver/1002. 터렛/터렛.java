import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(findIntersectionPoints(x1, y1,  r1, x2, y2, r2));

        }
    }

    public static int findIntersectionPoints(int x1, int y1, int r1, int x2, int y2, int r2) {
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (d == 0 && r1 == r2) {
            return -1; // Infinite number of points
        } else if (d == r1 + r2 || d == Math.abs(r1 - r2)) {
            return 1; // One intersection point
        } else if (Math.abs(r1 - r2) < d && d < r1 + r2) {
            return 2; // Two intersection points
        } else {
            return 0; // No intersection points
        }
    }
}