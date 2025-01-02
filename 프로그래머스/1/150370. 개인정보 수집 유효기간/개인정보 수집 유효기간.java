

import java.time.LocalDate;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] ar = {2, 3, 6};
        String[] asd = {"A 13"};
        String[] aa = {"2008.11.03 A"};
        // 12 2
        Arrays.stream(sol.solution("2009.12.28", asd, aa)).forEach(System.out::println);
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] split = today.split("\\.");
        int yyyy = Integer.parseInt(split[0]);
        int mm = Integer.parseInt(split[1]);
        int dd = Integer.parseInt(split[2]);
        LocalDate now = LocalDate.of(yyyy, mm, dd);

        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split1 = term.split(" ");
            map.put(split1[0], Integer.parseInt(split1[1]));
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] split1 = privacy.split(" ");
            int validPeriodMon = map.get(split1[1]);

            String dateTime = split1[0];
            String[] split2 = dateTime.split("\\.");
            int joinY = Integer.parseInt(split2[0]);
            int joinM = Integer.parseInt(split2[1]);
            int joinD = Integer.parseInt(split2[2]);

            if (joinD - 1 == 0) {
                joinD = 28;
                validPeriodMon--;
            } else {
                joinD -= 1;
            }

            joinM += validPeriodMon;
//            joinY += (joinM - 1) / 12;
//            joinM = (joinM - 1) % 12 + 1;

            if (joinM >= 13) {
                joinY += (joinM - 1) / 12;
                joinM = (joinM - 1) % 12 + 1;
            }

            LocalDate validPeriod = LocalDate.of(joinY, joinM, joinD);
            if (now.isAfter(validPeriod)) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


}
