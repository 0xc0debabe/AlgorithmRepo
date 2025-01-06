import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ids = {"muzi", "frodo", "apeach", "neo"};
        String[] rep = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        sol.solution(ids, rep, 2);
    }

    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportIdMap = new LinkedHashMap<>();
        Map<String, Integer> reportNumMap = new HashMap<>();
        for (String report : reports) {
            String[] split = report.split(" ");
            String from = split[0];
            String to = split[1];

            if (!reportIdMap.containsKey(from)) {
                reportIdMap.put(from, new HashSet<>());
            }

            Set<String> set = reportIdMap.get(from);
            if (set.add(to)) {
                reportNumMap.put(to, reportNumMap.getOrDefault(to, 0) + 1);
            }
            reportIdMap.put(from, set);
        }

        int[] answer = new int[id_list.length];
        int idx = 0;
        for (String id : id_list) {
            Set<String> set = reportIdMap.get(id);
            int cnt = 0;
            if (set != null) {
                for (String toReport : set) {
                    if (reportNumMap.containsKey(toReport)) {
                        int i = reportNumMap.get(toReport);
                        if (i >= k) cnt++;
                    }
                }
            }


            answer[idx++] = cnt;
        }

        return answer;
    }

}
