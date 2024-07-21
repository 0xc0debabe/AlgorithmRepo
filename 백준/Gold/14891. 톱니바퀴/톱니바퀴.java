import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    // N = 0, S = 1
    // pointer는 12시부터 0
    // dir = 1(시계방향), dir = -1(반시계방향)

    static int[][] gears = new int[5][9];
    static int[][] pointer = {
            {-1, -1, -1},
            {-1, 6, 2},
            {-1, 6, 2},
            {-1, 6, 2},
            {-1, 6, 2},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 4; i++) {
            String[] split = br.readLine().split("");

            for (int j = 0; j < split.length; j++) {
                gears[i][j] = Integer.parseInt(split[j]);
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            leftCheck(gearNum, -dir);
            rightCheck(gearNum, -dir);
            turn(gearNum, dir);
        }

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            int tmp = (pointer[i][2] + 6) % 8;
            if (gears[i][tmp] == 1) {
                answer += (int) Math.pow(2, i - 1);
            }
        }
//        int tmp = (pointer[4][1] + 2) % 8;
//        if (gears[4][tmp] == 1) {
//            answer += (int) Math.pow(2, 4 - 1);
//        }

        System.out.println(answer);
    }

    static void leftCheck(int gear, int dir) {
        if (gear == 1) return;
        int gearPoint = pointer[gear][1];
        int leftGearPoint = pointer[gear - 1][2];
        if (gears[gear][gearPoint] != gears[gear - 1][leftGearPoint]) {
            leftCheck(gear - 1, -dir);
            turn(gear - 1, dir);
        }
    }

    static void rightCheck(int gear, int dir) {
        if (gear == 4) return;
        int gearPoint = pointer[gear][2];
        int rightGearPoint = pointer[gear + 1][1];
        if (gears[gear][gearPoint] != gears[gear + 1][rightGearPoint]) {
            rightCheck(gear + 1, -dir);
            turn(gear + 1, dir);
        }
    }

    static void turn(int gear, int dir) {
        if (dir == 1) {
            pointer[gear][1] = (pointer[gear][1] + 7) % 8;
            pointer[gear][2] = (pointer[gear][2] + 7) % 8;
        } else {
            pointer[gear][1] = (pointer[gear][1] + 1) % 8;
            pointer[gear][2] = (pointer[gear][2] + 1) % 8;
        }
    }
}
