import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 행 검사
        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            for (int j = 0; j < N; j++) line[j] = map[i][j];
            if (canWalk(line)) answer++;
        }

        // 열 검사
        for (int j = 0; j < N; j++) {
            int[] line = new int[N];
            for (int i = 0; i < N; i++) line[i] = map[i][j];
            if (canWalk(line)) answer++;
        }

        System.out.println(answer);
    }

    static boolean canWalk(int[] arr) {
        boolean[] bridge = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = arr[i + 1] - arr[i];

            if (diff == 0) {
                continue; // 높이 같음 → 그냥 진행
            }

            // 오르막
            else if (diff == 1) {
                // 뒤에서 L칸 체크
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || arr[j] != arr[i] || bridge[j]) return false;
                    bridge[j] = true;
                }
            }

            // 내리막
            else if (diff == -1) {
                // 앞에서 L칸 체크
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || arr[j] != arr[i + 1] || bridge[j]) return false;
                    bridge[j] = true;
                }
            }

            // 높이 차이 2 이상 → 불가능
            else {
                return false;
            }
        }

        return true;
    }
}