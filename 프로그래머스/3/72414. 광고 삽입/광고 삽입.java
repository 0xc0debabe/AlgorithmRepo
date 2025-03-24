class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int totalRuntime = convertToSec(play_time);
        int adRuntime = convertToSec(adv_time);
        long[] totalSec = new long[totalRuntime + 1]; // 각 초마다의 재생 시청자 수를 기록
        
        // 로그를 바탕으로 차분 배열로 누적 재생시간 계산
        for (String log : logs) {
            String[] split = log.split("-");
            int startSec = convertToSec(split[0]);
            int endSec = convertToSec(split[1]);

            totalSec[startSec] += 1;
            totalSec[endSec] -= 1;
        }

        // 차분 배열을 이용하여 실제 누적 시청시간을 계산
        for (int i = 1; i <= totalRuntime; i++) {
            totalSec[i] += totalSec[i - 1];
        }

        // 광고가 삽입될 구간을 찾기 위해 구간 별 합을 구함
        long maxTime = 0;
        int maxStart = 0;

        long currentSum = 0;
        // 처음부터 광고 재생 시간만큼 구간을 누적
        for (int i = 0; i < adRuntime; i++) {
            currentSum += totalSec[i];
        }
        maxTime = currentSum;

        // 슬라이딩 윈도우 방식으로 광고 구간을 이동시키며 최적의 위치 찾기
        for (int i = adRuntime; i <= totalRuntime; i++) {
            currentSum += totalSec[i] - totalSec[i - adRuntime];
            if (currentSum > maxTime) {
                maxTime = currentSum;
                maxStart = i - adRuntime + 1; // 광고 구간의 시작 시간
            }
        }

        return convertToStr(maxStart);
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