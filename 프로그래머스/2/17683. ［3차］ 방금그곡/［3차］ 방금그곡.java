class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String m = "CDCDCD";
        String[] mu = {
                "12:00,12:10,NAME,CDCDCDE","12:30,12:50,NA,CD"
        };
        System.out.println(solution.solution(m, mu));
    }

    public String solution(String m, String[] musicinfos) {
        m = convertMelody(m);
        String answer = "(None)";
        int maxPlayTime = -1;

        for (String musicInfo : musicinfos) {
            String[] split = musicInfo.split(",");
            String startTime = split[0];
            String endTime = split[1];
            String songName = split[2];
            String rawMelody = split[3];

            int playTime = getMinutes(endTime) - getMinutes(startTime);
            String melody = getTotalMelody(playTime, convertMelody(rawMelody));

            if (melody.contains(m) && maxPlayTime < playTime) {
                answer = songName;
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private String getTotalMelody(int playTime, String melody) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playTime; i++) {
            sb.append(melody.charAt(i % melody.length()));
        }

        return sb.toString();
    }

    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private String convertMelody(String melody) {
        return melody.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

}



