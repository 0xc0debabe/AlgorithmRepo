import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int choose = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(arr).sum();
        double answer = 0;

        for (int i = 0; i < t; i++) {
            double sumTmp = sum;
            double arrTmp = arr[i];
            double answerTmp = 1;
            for (int j = 0; j < choose; j++) {
                answerTmp *= arrTmp-- / sumTmp--;
            }
            answer += answerTmp;
        }
        System.out.println(answer);
    }
}