import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();

            if (hs.contains(name)){
                hs.remove(name);
            } else hs.add(name);
        }

        ArrayList<String> al= new ArrayList<String>(hs);
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();

        for (int i = al.size(); i > 0; i--) {
            sb.append(al.get(i-1)).append("\n");
        }
        System.out.println(sb);
    }
}