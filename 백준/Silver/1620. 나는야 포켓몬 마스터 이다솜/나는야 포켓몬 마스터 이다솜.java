import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        HashMap<Integer, String> hq = new HashMap<Integer, String>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hm.put(s, i+1);
            hq.put(i+1, s);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))){
                sb.append(hq.get(Integer.parseInt(s))).append("\n");
            } else sb.append(hm.get(s)).append("\n");
        }
        System.out.println(sb);
    }
}