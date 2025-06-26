import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ranges[i] = new Range(s, e);
        }
        Arrays.sort(ranges);

        int now = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            Range range = ranges[i];
            int start = Math.max(range.start, now);
            int end = range.end;

            if (now >= end) continue;

            int r = end - start;
            int boardCount = r / l + (r % l == 0 ? 0 : 1);
            now = boardCount * l + start;
            answer += boardCount;
        }

        System.out.println(answer);
    }

    static class Range implements Comparable<Range>{
        int start, end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Range o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }

}