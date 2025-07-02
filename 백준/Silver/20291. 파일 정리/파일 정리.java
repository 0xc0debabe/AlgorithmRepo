import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String target = br.readLine().split("\\.")[1];
            map.put(target, map.getOrDefault(target, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet()) {
            sb.append(s).append(" ").append(map.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}