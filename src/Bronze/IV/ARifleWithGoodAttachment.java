package Bronze.IV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ARifleWithGoodAttachment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String a = stk.nextToken();
            String b = stk.nextToken();
            if (a.equals("ChongChong") || b.equals("ChongChong")) {
                set.add(a);
                set.add(b);
            }
            if (set.contains(a) || set.contains(b)) {
                set.add(a);
                set.add(b);
            }
        }
        System.out.println(set.size());
    }
}
