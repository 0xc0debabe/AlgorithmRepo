import java.io.*;

class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        dfs(s, t);
        System.out.println(answer);
    }

    static void dfs(String s, String t) {
        if(s.length() > t.length() || answer == 1) return;
        if(s.equals(t)) {
            answer = 1;
            return;
        }

        if(t.charAt(t.length() - 1) == 'A') {
            String sub = t.substring(0, t.length() - 1);
            dfs(s, sub);
        }

        if(t.charAt(0) == 'B') {
            String sub = reverseAndRemove(t);
            dfs(s, sub);
        }

    }

    static String reverseAndRemove(String t) {
        StringBuilder sb = new StringBuilder();
        for(int i = t.length() - 1; i >= 1; i--) {
            sb.append(t.charAt(i));
        }
        return sb.toString();
    }
}