import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt1 = 0;
        int cnt2 = 0;
        int answer = 65;
        int min = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr2 = new char[8][8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    arr2[i][2 * j] = 'W';
                }
                for (int j = 0; j < 4; j++) {
                    arr2[i][2 * j + 1] = 'B';
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    arr2[i][2 * j] = 'B';
                }
                for (int j = 0; j < 4; j++) {
                    arr2[i][2 * j + 1] = 'W';
                }
            }
        }

        char[][] arr3 = new char[8][8];
        for (int i = 0; i < 8; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    arr3[i][2 * j] = 'B';
                }
                for (int j = 0; j < 4; j++) {
                    arr3[i][2 * j + 1] = 'W';
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    arr3[i][2 * j] = 'W';
                }
                for (int j = 0; j < 4; j++) {
                    arr3[i][2 * j + 1] = 'B';
                }
            }
        }


        char[][] arr1 = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr1[i][j] = s.charAt(j);
            }
        }

        int extra_x = n - 8;
        int extra_y = m - 8;

        for (int i = 0; i <= extra_y; i++) {
            for (int j = 0; j <= extra_x; j++) {

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (arr1[k+j][l+i] != arr2[k][l]){
                            cnt1++;
                        }
                    }
                }

                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if (arr1[k+j][l+i] != arr3[k][l]){
                            cnt2++;
                        }
                    }
                }

                if (cnt1 >= cnt2){
                    min = cnt2;
                } else min = cnt1;

                if (answer >= min){
                    answer = min;
                }
                cnt1 = 0;
                cnt2 = 0;
            }
        }

        System.out.println(answer);
    }
}