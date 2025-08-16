import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] line;
        boolean[] alreadyInstalled;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            line = board[i];
            alreadyInstalled = new boolean[N];
            if(canMake(N, L, line, alreadyInstalled)) {
                answer++;
            }
        }

        for(int i = 0; i < N; i++) {
            line = new int[N];
            alreadyInstalled = new boolean[N];
            for(int j = 0; j < N; j++) {
                line[j] = board[j][i];
            }

            if(canMake(N, L, line, alreadyInstalled)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean canMake(int N, int L, int[] line, boolean[] alreadyInstalled) {
        for(int i = 0; i < N - 1; i++) {
            int diff = line[i + 1] - line[i];
            if(diff == 0) continue;

            if(diff == 1) {
                int standard = line[i];
                for(int j = 0; j < L; j++) {
                    int idx = i - j;
                    if(idx < 0 || standard != line[idx] || alreadyInstalled[idx]) return false;
                }

                for(int j = 0; j < L; j++) {
                    int idx = i - j;
                    alreadyInstalled[idx] = true;
                }


            } else if(diff == -1) {
                int standard = line[i + 1];
                for(int j = 0; j < L; j++) {
                    int idx = i + j + 1;
                    if(idx >= N || standard != line[idx] || alreadyInstalled[idx]) return false;
                }

                for(int j = 0; j < L; j++) {
                    int idx = i + j + 1;
                    alreadyInstalled[idx] = true;
                }


            } else {
                return false;
            }
        }
        return true;
    }

}