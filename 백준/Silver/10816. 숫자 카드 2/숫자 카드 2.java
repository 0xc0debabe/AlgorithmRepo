import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card1 = Integer.parseInt(st.nextToken());
            if (hm.containsKey(card1)){
                int a = hm.get(card1);
                a++;
                hm.put(card1, a);
            } else hm.put(card1, 1);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int card2 = Integer.parseInt(st.nextToken());
            if (!hm.containsKey(card2)){
                sb.append(0).append(" ");
            } else sb.append(hm.get(card2)).append(" ");
        }
        System.out.println(sb);
    }
}