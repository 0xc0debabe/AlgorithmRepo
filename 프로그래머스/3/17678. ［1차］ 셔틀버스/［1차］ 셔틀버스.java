import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] t = {"09:10", "09:09", "08:00"};
        solution.solution(2, 10, 2, t);
    }

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            pq.add(timeToMinute(time));
        }

        int nowTime = timeToMinute("09:00");
        int con = -1;
        int lastCrew = 0;
        for (int i = 0; i < n; i++) {
            int capacity = m;
            while (!pq.isEmpty() && capacity > 0 && canGetOnTheBus(nowTime, pq.peek())) {
                lastCrew = pq.poll();
                capacity--;
            }

            if (i == n - 1) {
                if (capacity > 0) {
                    con = nowTime;
                } else {
                    con = lastCrew - 1;
                } 
            }
            
            nowTime += t;
        }
        
        return minuteToTime(con);
    }

    private boolean canGetOnTheBus(int nowTime, int target) {
        return nowTime >= target;
    }

    private int timeToMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String minuteToTime(int min) {
        int hour = min / 60;
        int minute = min % 60;

        return String.format("%02d:%02d", hour, minute);
    }

}