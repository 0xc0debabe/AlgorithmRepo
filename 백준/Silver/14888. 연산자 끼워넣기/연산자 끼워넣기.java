import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operator = new int[4];
    static int[] number;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        number = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(number[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);


    }

    static void dfs(int num, int index) {
        if (index == n) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                switch (i) {
                    case 0 : dfs(num + number[index], index + 1); break;
                    case 1 : dfs(num - number[index], index + 1); break;
                    case 2 : dfs(num * number[index], index + 1); break;
                    case 3 : dfs(num / number[index], index + 1); break;
                }

                operator[i]++;
            }

        }
    }
}