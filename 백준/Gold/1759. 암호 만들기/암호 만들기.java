import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int l, c;
    static String[] arr;
    static boolean[] isVisited;
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new String[c];
        isVisited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken();
        }

        solution(0, 0, "", 0, 0);
        answer.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for (String s : answer) {
            sb.append(s.replaceAll("[\\[,\\] ]", "")).append("\n");
        }
        System.out.println(sb);
    }

    static void solution(int depth, int idx, String tmp, int vowel, int consonant) {
        if (depth == l) {
            if (vowel >= 1 && consonant >= 2) {
                answer.add(sort(tmp));
            }
            return;
        }

        for (int i = idx; i < c; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (isVowel(arr[i])){
                    vowel += 1;
                } else{
                    consonant += 1;
                }

                tmp += arr[i];
                solution(depth + 1, i + 1, tmp, vowel, consonant);

                char c1 = tmp.charAt(tmp.length() - 1);
                if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
                    vowel -= 1;
                } else {
                    consonant -= 1;
                }
                tmp = tmp.substring(0, tmp.length() - 1);
                isVisited[i] = false;
            }
        }
    }

    static boolean isVowel(String s) {
        return s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u");
    }

    static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}