class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] sc = {700, 800, 1100};
        int[][] time = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        solution.solution(sc, time, 5);
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int k = 0; k < schedules.length; k++) {
            int schedule = schedules[k];
            int workStartTime = schedule + 10;
            if (workStartTime % 100 >= 60) {
                workStartTime = workStartTime - 60 + 100;
            }
            boolean flag = true;


            for (int j = 0; j < timelogs[k].length; j++) {
                if ((j + startday) % 7 == 0 || (j + startday) % 7 == 6) {
                    continue;
                }

                int timeLog = timelogs[k][j];

                if (workStartTime < timeLog) {
                    flag = false;
                    break;
                }
            }


            if (flag) answer++;
        }

        return answer;
    }

}