import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        boolean[] isVisited;
        String[] blank;
        int[] DSLR = new int[4];
        String[] dslr = {"D", "S", "L", "R"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            isVisited = new boolean[10_001];
            blank = new String[10_001];
            Arrays.fill(blank, "");
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            isVisited[start] = true;

            while (!queue.isEmpty()) {
                int poll = queue.poll();

                if (poll == end) {
                    sb.append(blank[end]).append("\n");
                }

                DSLR[0] = (2 * poll) % 10_000;
                DSLR[1] = (poll + 10000 - 1) % 10_000;
                DSLR[2] = (poll % 1000 * 10) + poll / 1000;
                DSLR[3] = (poll % 10) * 1000 + poll / 10;

                for (int j = 0; j < 4; j++) {
                    if (!isVisited[DSLR[j]]) {
                        isVisited[DSLR[j]] = true;
                        blank[DSLR[j]] = blank[poll] + dslr[j];
                        queue.add(DSLR[j]);
                    }
                }
            }
        }

        System.out.println(sb);
    }
}