import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 이항계수 (N
//                 K) 란  nCk = n! / (n-k)! * k! n개중 k 선택(단, 중복X, 순서X)
//        공 10개중 3개를 뽑는 경우의 수 10 9 8 / 3 2 1  ( 3 2 1 인 경우는 빨 파 노 일경우 빨을 선택했을때 파노가 남기때문에 중복제거)
        int answer = 1;
        int idx = 1;
        for (int i = n; i > m; i--) {
            answer *= i;
            answer /= idx++;
        }
        System.out.println(answer);
    }
}