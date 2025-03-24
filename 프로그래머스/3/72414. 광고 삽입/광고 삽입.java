
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String play = "00:00:10";
        String adv = "00:00:04";
        String[] logs = {"00:00:00-00:00:05", "00:00:03-00:00:08"};
        System.out.println(solution.solution(play, adv, logs));
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int totalRuntime = convertToSec(play_time);
        int adRuntime = convertToSec(adv_time);
        long[] totalSec = new long[totalRuntime + 3];

        for (String log : logs) {
            String[] split = log.split("-");
            String start = split[0];
            String end = split[1];

            int startSec = convertToSec(start);
            int endSec = convertToSec(end);

            totalSec[startSec + 1] += 1;
            totalSec[endSec + 1] -= 1;
        }

        for (int i = 1; i < totalSec.length - 1; i++) {
            totalSec[i] = totalSec[i - 1] + totalSec[i];
        }

        for (int i = 1; i < totalSec.length - 1; i++) {
            totalSec[i] = totalSec[i - 1] + totalSec[i];
        }

        long max = -1;
        int tmp = 0;
        int right = adRuntime;
        for (int i = 1; i <= totalRuntime - adRuntime + 1; i++) {
            if (totalSec[right] - totalSec[i - 1] > max) {
                max = totalSec[right] - totalSec[i - 1];
                tmp = i - 1;
            }

            right++;
        }

        return convertToStr(tmp);
    }

    private int convertToSec(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
    }

    private String convertToStr(int idx) {
        String hour = String.format("%02d", idx / 3600);
        String minute = String.format("%02d", (idx % 3600) / 60);
        String sec = String.format("%02d", (idx % 3600) % 60);

        return hour + ":" + minute + ":" + sec;
    }

}
