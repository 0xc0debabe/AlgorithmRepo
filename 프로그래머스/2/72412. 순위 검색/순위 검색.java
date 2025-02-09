import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] in = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] q = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        sol.solution(in, q);
    }

    Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        for (String i : info) {
            String[] split = i.split(" ");
            dfs("", split, 0);
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            String replace = q.replaceAll(" and ", "");
            String[] split = replace.split(" ");
            String queryIdx = split[0];
            int target = Integer.parseInt(split[1]);

            if (map.containsKey(queryIdx)) {
                List<Integer> list = map.get(queryIdx);
                answer[i] = binarySearch(list, target);
            }
        }

        return answer;
    }

    private static int binarySearch(List<Integer> list, int score) {
        int start = 0, end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return list.size() - start;
    }

    private void dfs(String str, String[] split, int depth) {
        if (depth == 4) {
            List<Integer> list = map.getOrDefault(str, new ArrayList<>());
            list.add(Integer.parseInt(split[4]));
            map.put(str, list);
            return;
        }

        dfs(str + split[depth], split, depth + 1);
        dfs(str + "-", split, depth + 1);
    }

}