import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk =  new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        stk =  new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!firstMap.containsKey(num)) {
                firstMap.put(num, i);
            }
        }

        list.sort((a, b) -> {
            int x = map.get(a);
            int y = map.get(b);

            if (x == y) {
                return firstMap.get(a) - firstMap.get(b);
            }
            return y - x;
        });

        StringBuilder sb = new StringBuilder();
        for (int v : list) {
            sb.append(v).append(' ');
        }

        System.out.println(sb.toString());
    }

}