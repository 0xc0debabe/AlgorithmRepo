import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "23:00", "30"}, {"computer", "12:30", "100"}};
        String[] solution1 = solution.solution(plans);
        for (String s : solution1) {
            System.out.println(s);
        }
    }

    public String[] solution(String[][] plans) {
        Arrays.sort(plans, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        String prevTime = plans[0][1];
        String[] answer = new String[plans.length];
        int idx = 0;
        Stack<String[]> stack = new Stack<>();
        for (int i = 0; i < plans.length; i++) {
            String[] plan = plans[i];
            int restTime = subTime(plan[1], prevTime);
            while (!stack.isEmpty() && restTime > 0) {
                String[] prevPlan = stack.pop();
                int playtime = Integer.parseInt(prevPlan[2]);
                if (restTime - playtime >= 0) {
                    answer[idx++] = prevPlan[0];
                } else {
                    prevPlan[2] = String.valueOf(playtime - restTime);
                    stack.add(prevPlan);
                }

                restTime -= playtime;
            }

            stack.add(plan);
            prevTime = plan[1];
        }

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop()[0];
        }

        return answer;
    }

    private int subTime(String nowTime, String prevTime) {
        int nowMin = timeToMinute(nowTime);
        int prevMin = timeToMinute(prevTime);
        return nowMin - prevMin;
    }

    private int timeToMinute(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

}