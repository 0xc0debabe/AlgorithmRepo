package Silver.V;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GomgomiWithABrightGreeting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String k = br.readLine();
            if (!k.equals("ENTER")) {
                if (!map.containsKey(k)) {
                    map.put(k, i + 1);
                    answer++;
                }
            } else {
                answer = map.size();
                map.clear();
            }
        }

        System.out.println(answer);
    }
}
