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
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hm.put(s, i);
        }
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if (hm.containsKey(s)){
                hs.add(s);
                cnt++;
            }
        }
        
        List<String> li = new ArrayList<String>(hs);
        Collections.sort(li);

        for(String s : li){
            sb.append(s).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}