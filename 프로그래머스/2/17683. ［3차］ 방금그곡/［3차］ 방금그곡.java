class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String m = "BA";
        String[] mu = {
                "12:00,12:04,Song,A#B"
        };
        System.out.println(solution.solution(m, mu));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;

        // 멜로디 변환 (C# → c, D# → d 등)
        m = convertMelody(m);

        for (String info : musicinfos) {
            String[] parts = info.split(",");
            String start = parts[0];
            String end = parts[1];
            String title = parts[2];
            String melody = convertMelody(parts[3]);

            // 1. 재생 시간 계산
            int playTime = getMinutes(end) - getMinutes(start);

            // 2. 실제 재생된 멜로디 구성
            String playedMelody = getPlayedMelody(melody, playTime);

            // 3. 기억한 멜로디가 포함되는지 확인
            if (playedMelody.contains(m)) {
                // 4. 가장 긴 재생 시간의 곡 선택 (같은 경우 먼저 입력된 곡)
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = title;
                }
            }
        }
        return answer;
    }

    // HH:MM 형식의 시간을 분(min) 단위로 변환
    private int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    // C#, D#, F#, G#, A# → 소문자로 변환하여 비교
    private String convertMelody(String melody) {
        return melody.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("B#", "b")
                .replace("A#", "a");
    }

    // 주어진 재생 시간만큼 멜로디 반복/자르기
    private String getPlayedMelody(String melody, int playTime) {
        StringBuilder played = new StringBuilder();
        int len = melody.length();

        for (int i = 0; i < playTime; i++) {
            played.append(melody.charAt(i % len));
        }
        return played.toString();
    }

}



