import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] calendar = new int[366];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int j = s; j <= e; j++) calendar[j]++;
        }

        int height = 0;
        int width = 0;
        int answer = 0;
        for(int i = 1; i <= 365; i++) {
            if(calendar[i] == 0) {
                answer += height * width;
                height = 1;
                width = 0;
            } else if(calendar[i] >= 1) {
                width++;
                height = Math.max(height, calendar[i]);
            }


        }

        answer += height * width;
        System.out.println(answer);
    }

}