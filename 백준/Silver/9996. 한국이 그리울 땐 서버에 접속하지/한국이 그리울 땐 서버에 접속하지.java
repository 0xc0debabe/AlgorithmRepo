import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();

        String[] parts = pattern.split("\\*");
        String prefix = parts[0];
        String suffix = parts[1];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String filename = br.readLine();
            if(filename.length() < prefix.length() + suffix.length()) {
                sb.append("NE\n");
                continue;
            }

            boolean startsWith = filename.startsWith(prefix);
            boolean endsWith = filename.endsWith(suffix);

            if(startsWith && endsWith) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }

        System.out.println(sb);
    }
}