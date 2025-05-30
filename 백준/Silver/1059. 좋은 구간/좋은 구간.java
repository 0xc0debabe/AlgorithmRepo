import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }
        int target = Integer.parseInt(br.readLine());
        int tmp = target;
        int min = 1;
        while (tmp > 0) {
            if (map.containsKey(tmp)) {
                min = tmp + 1;
                break;
            }
            tmp--;
        }
        int max = 50;
        tmp = target;
        while (tmp <= 1000) {
            if (map.containsKey(tmp)) {
                max = tmp - 1;
                break;
            }
            tmp++;
        }

        int answer = 0;
        for (int i = min; i <= target; i++) {
            for (int j = target; j <= max; j++) {
                int t1 = i;
                int t2 = j;
                if (i == j) continue;
                answer++;
            }
        }

        System.out.println(answer);
    }

}
