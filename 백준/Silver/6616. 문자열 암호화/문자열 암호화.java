import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            String sentence = br.readLine().replaceAll(" ", "");
            char[] arr = new char[sentence.length()];
            int idx = 0;

            for (int i = 0; i < sentence.length() & idx < sentence.length(); i++) {

                for (int j = i; j < sentence.length(); j += n) {
                    arr[j] = sentence.charAt(idx++);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(Character.toUpperCase(c));
            }

            System.out.println(sb);
        }
    }
}