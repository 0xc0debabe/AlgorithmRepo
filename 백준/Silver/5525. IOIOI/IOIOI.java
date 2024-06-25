
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            tmp = tmp.concat("IO");
        }
        tmp += "I";
        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int answer = 0;
        while (s.length() > 0) {
            if (s.startsWith(tmp)) {
                answer++;
                s = s.substring(2);
            } else {
                s = s.substring(1);
            }
        }
        System.out.println(answer);
    }
}