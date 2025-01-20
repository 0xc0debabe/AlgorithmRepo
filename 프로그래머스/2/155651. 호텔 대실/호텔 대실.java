import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] book = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(sol.solution(book));
    }

    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));
        PriorityQueue<String[]> pq = new PriorityQueue<>((x, y) -> x[1].compareTo(y[1]));

        for (String[] book : book_time) {
            if (!pq.isEmpty()) {
                String[] prevBook = pq.peek();
                if (isEnded(prevBook[1], book[0])) {
                    pq.poll();
                }
            }

            pq.add(book);
        }

        return pq.size();
    }

    private boolean isEnded(String prevEnd, String nextStart) {
        int prevMin = timeToMin(prevEnd) + 10;
        int nextMin = timeToMin(nextStart);
        return prevMin <= nextMin;
    }

    private int timeToMin(String prev) {
        String[] split = prev.split(":");
        int hour = Integer.parseInt(split[0]);
        int min = Integer.parseInt(split[1]);
        return hour * 60 + min;
    }

}