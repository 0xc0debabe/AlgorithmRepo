import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static List<String> list = new ArrayList<>();
    static String[] blank;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        blank = new String[3];
        isVisited = new boolean[10];
        solution(0);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String listNum = iterator.next();
                int s = 0;
                int b = 0;

                for (int k = 0; k < 3; k++) {
                    char c = listNum.charAt(k);
                    char c1 = num.charAt(k);
                    if (c == c1) s++;
                }

                for (int k = 0; k < 3; k++) {
                    char c = num.charAt(k);
                    for (int l = 0; l < 3; l++) {
                        if (k == l) continue;
                        char c1 = listNum.charAt(l);
                        if (c == c1) b++;
                    }
                }

                if (strike != s || ball != b) {
                    iterator.remove();
                }

            }
        }

        System.out.println(list.size());
    }

    static void solution(int depth) {
        if (depth == 3) {
            StringBuilder s = new StringBuilder();
            for (String s1 : blank) {
                s.append(s1);
            }
            list.add(s.toString());
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                blank[depth] = String.valueOf(i);
                solution(depth + 1);
                isVisited[i] = false;
            }
        }

    }
}
