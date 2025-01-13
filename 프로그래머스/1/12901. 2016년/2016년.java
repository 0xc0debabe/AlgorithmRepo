import java.time.DayOfWeek;
import java.time.LocalDate;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(5, 24);
    }

    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        return days[value % 7];
    }
}
