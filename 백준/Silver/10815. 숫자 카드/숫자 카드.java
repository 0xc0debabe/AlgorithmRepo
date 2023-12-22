import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cardn = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cardn[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] cardm = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cardm[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int v : cardn){
            hm.put(v, 1);
        }

        StringBuilder sb = new StringBuilder();
        for(int v : cardm){
            if (!hm.containsKey(v)){
                sb.append(0).append(" ");
            } else sb.append(1).append(" ");
        }
        System.out.println(sb);
    }
}