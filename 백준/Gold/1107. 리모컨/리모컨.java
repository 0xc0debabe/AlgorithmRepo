import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static boolean[] isBroken = new boolean[10];
    static int startNum = 100;
    static int incNum = 0;
    static int decNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        if (n > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                isBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer;
        if (startNum == target) {
            answer = 0;
        } else if (n == 10) {
            answer = Math.abs(target - startNum);
        } else {

            int decTarget = target;
            while (true) {
                if (decTarget <= 0) {
                    if (decTarget == 0) {
                        if (isBroken[0]) {
                            decNum = 100000000;
                        }
                    }
                    break;
                }
                int tmp = decTarget;
                boolean needMinus = false;
                while (tmp > 0) {
                    int check = tmp % 10;
                    if (isBroken[check]) {
                        needMinus = true;
                        break;
                    }
                    tmp /= 10;
                }
                if (needMinus) {
                    decTarget--;
                } else {
                    decNum = decTarget;
                    break;
                }
            }

            int incTarget = target;
            boolean flag = false;
            while (true) {
                if (incTarget >= 1_000_001) {
                    incNum = 100000000;
                    break;
                }
                int tmp = incTarget;
                boolean needPlus = false;
                while (tmp > 0) {
                    int check = tmp % 10;
                    if (isBroken[check]) {
                        needPlus = true;
                        break;
                    }
                    tmp /= 10;
                }
                if (needPlus) {
                    incTarget++;
                } else {
                    incNum = incTarget;
                    if (target == 0 && isBroken[target] && !flag) {
                        incTarget++;
                        flag = true;
                        continue;
                    }
                    break;
                }
            }
            int inc = Math.abs(incNum - target) + String.valueOf(incNum).length();
            int dec = Math.abs(decNum - target) + String.valueOf(decNum).length();
            answer = Math.min(Math.abs(target - startNum), Math.min(inc, dec));
        }

        System.out.println(answer);
    }
}
