import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        list.sort((x, y) -> {
            if (x.length() == y.length()) {
                int sumA = 0;
                int sumB = 0;
                for (int i = 0; i < x.length(); i++) {
                    if (Character.isDigit(x.charAt(i))) {
                        sumA += x.charAt(i) - '0';
                    }

                    if (Character.isDigit(y.charAt(i))) {
                        sumB += y.charAt(i) - '0';
                    }
                }

                if (sumA == sumB) {
                    return x.compareTo(y);
                }

                return sumA - sumB;
            }

            return x.length() - y.length();
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
