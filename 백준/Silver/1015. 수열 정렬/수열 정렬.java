import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int visitValue = -1;
            for (int j = 0; j < n; j++) {
                if (!isVisited[j] && arr[j] < min) {
                    min = arr[j];
                    visitValue = j;
                }
            }
            isVisited[visitValue] = true;
            answer[visitValue] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}
