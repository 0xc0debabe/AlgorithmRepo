import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] compareArr = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int win = Integer.parseInt(st.nextToken());
            int lose = Integer.parseInt(st.nextToken());
            compareArr[win][lose] = 1;
            compareArr[lose][win] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (compareArr[i][k] == 1 && compareArr[k][j] == 1) {
                        compareArr[i][j] = 1;
                        compareArr[j][i] = -1;
                    } else if (compareArr[i][j] == -1 && compareArr[k][j] == -1) {
                        compareArr[i][j] = -1;
                        compareArr[j][i] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;

                if (compareArr[i][j] == 0) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}