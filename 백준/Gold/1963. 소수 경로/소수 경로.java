import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int answer;
    static boolean[] isPrime = new boolean[10_001];
    static int[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < 10_001; i++) {
            if (isPrime[i]) {

                for (int j = i * i; j < 10_001; j += i) {
                    isPrime[j] = false;
                }
            }

        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            isVisited = new int[10_001];
            isVisited[s] = 1;

            while (!queue.isEmpty()) {
                int poll = queue.poll();
                if (poll == e) break;

                for (int digit = 0; digit < 4; digit++) {
                    for (int number = 0; number < 10; number++) {

                        if (digit == 0 && number == 0) continue;

                        int changeNum = change(poll, digit, number);
                        if (isPrime[changeNum] && isVisited[changeNum] == 0) {
                            isVisited[changeNum] = isVisited[poll] + 1;
                            queue.add(changeNum);
                        }
                    }
                }
            }

            sb.append(isVisited[e] - 1).append("\n");
        }

        System.out.println(sb);
    }

    static int change(int target, int digit, int number) {
        StringBuilder sb = new StringBuilder(String.valueOf(target));
        sb.setCharAt(digit, (char) ('0' +  number));
        return Integer.parseInt(sb.toString());
    }
}